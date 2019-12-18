package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import service.AsyncService;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2019/12/6 17:02.
 */
@RestController
public class StompController {
//    @Autowired
//    private SimpMessagingTemplate template;

//    @Autowired
//    AsyncService asyncService;

    @Autowired
    TaskScheduler taskScheduler;

    /**
     * 测试STOMP主体为JSON如何转换
     */
    @GetMapping("/convert")
    public String conver() {


        //创建Jackson2构建器，并配置
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        ObjectMapper objectMapper = builder.build();//创建Jackson2实例

        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(objectMapper);//设置Jackson2实例，替换转换器底层Jackson2的默认配置


        Person person = new Person();
        person.setName("bob");
        person.setAge(15);
        String payload = null;
        try {
            payload = objectMapper.writeValueAsString(person);//创建JSON字符串，作为STOMP帧数据主体
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        Message<byte[]> message = new GenericMessage<>(payload.getBytes());//创建信息对象
        Person result = (Person) converter.fromMessage(message, Person.class);//转换信息对象为Java Bean


        return result.getName() + "-" + result.getAge();

    }

    /**
     * STOMP客户端
     */
    @GetMapping("/stomp")
    public String stomp() {


        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);

//        stompClient.setMessageConverter(new StringMessageConverter());//字符串转换器
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());//JSON转换器

//        stompClient.setTaskScheduler(taskScheduler);//增加计划任务器
        stompClient.setDefaultHeartbeat(new long[] {0, 0});//配置心跳间隔


        String url = "ws://192.168.0.126:8080/ep";
        StompSessionHandler sessionHandler = new StompSessionHandlerAdapter() {

            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                System.out.println("~~client controller - afterConnected~~");
                System.out.println("session is " + session);
                System.out.println("connectedHeaders is " + connectedHeaders);


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 0; i < 2; i++) {
                                Thread.sleep(2000L);
                                System.out.println("---------send-" + i + "--------");
                                session.send("/app/appSendOne", "bob")
                                .addReceiptLostTask(()->{
                                    System.out.println("~~ReceiptLostTask~~");
                                });
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }

            @Override
            public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
                System.out.println("~~client controller - handleException~~");
                System.out.println("session is " + session);
                System.out.println("command is " + command);
                System.out.println("headers is " + headers);
                System.out.println("payload is " + new String(payload));
                System.out.println("exception is " + exception);
            }

            @Override
            public void handleTransportError(StompSession session, Throwable exception) {
                System.out.println("~~client controller - handleTransportError~~");
                System.out.println("session is " + session);
                System.out.println("exception is " + exception);
            }
        };
        stompClient.connect(url, sessionHandler)
                .addCallback(stompSession -> {
                    System.out.println("~~onSuccess~~");
                    System.out.println(stompSession);

//                    stompSession.setAutoReceipt(true);

                    stompSession.subscribe("/topic/something", new StompFrameHandler() {

                        @Override
                        public Type getPayloadType(StompHeaders headers) {
                            System.out.println("~~client controller|subscribe - getPayloadType~~");
                            System.out.println("headers is " + headers);
//                            return Person.class;
                            return String.class;
                        }

                        @Override
                        public void handleFrame(StompHeaders headers, Object payload) {
                            System.out.println("~~client controller|subscribe - handleFrame~~");
                            System.out.println("headers is " + headers);
                            System.out.println("payload is " + payload);
                        }
                    });
                }, Throwable::printStackTrace);

        return "stompSub";
    }


    /**
     * 获取客户端发送的信息
     */
    //方式一：使用注解设置待发送信息的目标URL
    @MessageMapping("/appSendOne")
    @SendTo("/topic/something")//回应给用户
    public String appSendOne(Message<String> stringMessage) {
        System.out.println("~~controller|appSendOne~~");
        System.out.println("stringMessage" + stringMessage);
        String payLoad = "Server|" + stringMessage.getPayload();
        return payLoad;
    }
    //方式二：使用模板设置发送信息的目标URL
//    @MessageMapping("/appSendTwo")
//    public void appSendTwo(TextMessage textMessage) {
//        System.out.println("~~controller|appSendTwo~~");
//        String payLoad = "Server|" + textMessage.getPayload();
//        this.template.convertAndSend("/topic/something", new Person());
//    }
    //方式三：使用注解设置待发送信息的目标URL
//    @MessageMapping("/appSendOne")
//    @SendToUser("/queue/appSendOne")//回应给用户
//    public TextMessage appSendOne(Message<String> stringMessage) {
//        System.out.println("~~controller|appSendOne~~");
//        System.out.println("stringMessage" + stringMessage);
//
//        String payLoad = "Server|" + stringMessage.getPayload();
//        return new TextMessage(payLoad);
//    }
    //方式四：异步处理信息
//    @MessageMapping("/asyncMsg")
//    @SendTo("/topic/something")
//    public ListenableFuture<String> asyncMsg(Message message) {
//        System.out.println("~~controller|asyncMsg~~");
//        String payLoad = "Server|" + message.getPayload();
//
////        //方法一：直接返回
////        return asyncService.task();
//
//
//        //方式二：绑定回调
//        ListenableFuture<String> stringListenableFuture =  asyncService.task();
//        stringListenableFuture.addCallback(result -> {
//                    System.out.println("~~onSuccess~~");
//            System.out.println("result is " + result);
//                }, Throwable::printStackTrace);
//        return stringListenableFuture;
//    }
    //方式五：返回Java对象
//    @MessageMapping("/appSendOne")
//    @SendTo("/topic/something")//回应给用户
//    public Person appSendOne(Message<String> stringMessage) {
//        System.out.println("~~controller|appSendOne~~");
//        System.out.println("stringMessage" + stringMessage);
//
//        Person person = new Person();
//        person.setName(stringMessage.getPayload());
//        person.setAge(15);
//
//        return person;
//    }


    /**
     * 获取用户
     */
//    @MessageMapping("/appUser")
//    public void appUser(Message message) {
//        System.out.println("~~controller|appUser~~");
//        System.out.println("message is " + message);
//
//
//        String payLoad = "Server|" + message.getPayload();
//        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);//获取访问器
//
//        String user = accessor.getUser() == null ? accessor.getSessionId(): accessor.getUser().getName();//获取CONNECT帧中验证身份时增加的用户名
//        System.out.println(user);
//
//        template.convertAndSendToUser(user, "/app/appUser", payLoad, accessor.getMessageHeaders());
//    }


    /**
     * 访问头信息
     */
//    @MessageMapping("/topic/something")
//    @SendTo("/topic/appHeader")
//    public Message appHeader(Message message) {
//        System.out.println("~~controller|appHeader~~");
//
//        //方式一：创建副本，不可修改
////        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
////        accessor.setHeader("xxx", "yyy");
////        message = MessageBuilder.createMessage(message.getPayload(), accessor.getMessageHeaders());
////        System.out.println(message);
//
//
//        //方式二：创建副本，可修改源对象
//                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
//                accessor.setHeader("xxx", "yyy");
//                System.out.println(message);
//
//        return message;
//    }


    /**
     * 发送给用户
     */
    //方式一：使用注解
//    @MessageMapping("/appSendThree")
//    @SendToUser("/ooo")
//    public TextMessage appSendThree(Message<String> stringMessage) {
//        System.out.println("~~controller|appSendThree~~");
//        System.out.println("stringMessage" + stringMessage);
//
//        String payLoad = "Server|" + stringMessage.getPayload();
//        return new TextMessage(payLoad);
//    }
    //方式二：使用模板类
//    @MessageMapping("/appSendThree")
//    public void appSendThree(Message<String> stringMessage, SimpMessageHeaderAccessor accessor) {
//        System.out.println("~~controller|appSendThree~~");
//        System.out.println("stringMessage" + stringMessage);
//
//        String payLoad = "Server|" + stringMessage.getPayload();
//
//        String user = accessor.getSessionId();
//
//        template.convertAndSendToUser(user, "/ooo", payLoad, accessor.getMessageHeaders());
//    }


//    @MessageMapping("/appSendFour")
//    @SendTo("/sgl")
//    public TextMessage appSendFour(Message<String> stringMessage) {
//        System.out.println("~~controller|appSendFour~~");
//        System.out.println("stringMessage" + stringMessage);
//
//        String payLoad = "Server|" + stringMessage.getPayload();
//        return new TextMessage(payLoad);
//    }


    /**
     * 直接回复给客户端
     * 客户端发订阅帧可以直接被回复
     */
    //方式一：使用订阅URL作为目标URL
//    @SubscribeMapping("/sub")
//    public void appSub(Message message) {
//        System.out.println("~~controller|appSub~~");
//        this.template.convertAndSend("/topic/something", new TextMessage("ok"));
//    }
    //方式二：自定义目标URL
//    @SubscribeMapping("/sub")
//    @SendTo("/topic/something")
//    public TextMessage appSub(Message message) {
//        System.out.println("~~controller|appSub~~");
//        return new TextMessage("ok");
//    }

}
