package controller;

import dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2019/12/6 17:02.
 */
@RestController
public class StompController {
    @Autowired
    private SimpMessagingTemplate template;


    /**
     * STOMP客户端
     */
//    @GetMapping("/stomp")
//    public String stomp() {
//
//        WebSocketClient webSocketClient = new StandardWebSocketClient();
//        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
//        stompClient.setMessageConverter(new StringMessageConverter());
////        stompClient.setTaskScheduler(taskScheduler);
//
//        String url = "ws://192.168.0.126:8080/ep";
//        StompSessionHandler sessionHandler = new StompSessionHandlerAdapter() {
//            @Override
//            public Type getPayloadType(StompHeaders headers) {
//                System.out.println("~~controller|send - getPayloadType~~");
//                System.out.println("headers is " + headers);
//                return String.class;
//            }
//
//            @Override
//            public void handleFrame(StompHeaders headers, Object payload) {
//                System.out.println("~~controller|send - handleFrame~~");
//                System.out.println("headers is " + headers);
//                System.out.println("payload is " + payload);
//
//            }
//
//            @Override
//            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
//                System.out.println("~~controller|send - afterConnected~~");
//                System.out.println("session is " + session);
//                System.out.println("connectedHeaders is " + connectedHeaders);
//
////                StompController.this.session = session;
//
//                session.subscribe("/topic/something", new StompFrameHandler() {
//
//                    @Override
//                    public Type getPayloadType(StompHeaders headers) {
//                        System.out.println("~~controller|subscribe - getPayloadType~~");
//                        System.out.println("headers is " + headers);
//                        return String.class;
//                    }
//
//                    @Override
//                    public void handleFrame(StompHeaders headers, Object payload) {
//                        System.out.println("~~controller|subscribe - handleFrame~~");
//                        System.out.println("headers is " + headers);
//                        System.out.println("payload is " + payload);
//                    }
//
//                });
//
//
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            for (int i = 0; i < 2; i++) {
//                                Thread.sleep(2000L);
//                                System.out.println("---------send-" + i + "--------");
//                                session.send("/app/something", "payload99999");
//                            }
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
//
//
//            }
//
//            @Override
//            public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
//                System.out.println("~~controller|send - handleException~~");
//                System.out.println("session is " + session);
//                System.out.println("command is " + command);
//                System.out.println("headers is " + headers);
//                System.out.println("payload is " + payload);
//
//            }
//
//            @Override
//            public void handleTransportError(StompSession session, Throwable exception) {
//                System.out.println("~~controller|send - handleTransportError~~");
//                System.out.println("session is " + session);
//                System.out.println("exception is " + exception);
//            }
//        };
//        stompClient.connect(url, sessionHandler);
//
//
//        return "stompSub";
//    }


    /**
     * 获取客户端发送的信息
     */
    //方式一：使用注解设置发送信息的目标URL
//    @MessageMapping("/appSendOne")
//    @SendTo("/topic/something")
//    public TextMessage appSendOne(Message<String> stringMessage) {
//        System.out.println("~~controller|appSendOne~~");
//        System.out.println("stringMessage" + stringMessage);
//
//        String payLoad = "Server|" + stringMessage.getPayload();
//        return new TextMessage(payLoad);
//    }
    //方式二：使用模板设置发送信息的目标URL
//    @MessageMapping("/appSendTwo")
//    public void appSendTwo(TextMessage textMessage) {
//        System.out.println("~~controller|appSendTwo~~");
//        String payLoad = "Server|" + textMessage.getPayload();
//        this.template.convertAndSend("/topic/something", new Person());
//    }


    /**
     * 获取用户
     */
    @MessageMapping("/appUser")
    public void appUser(Message message) {
        System.out.println("~~controller|appUser~~");
        System.out.println("message is " + message);

        String payLoad = "Server|" + message.getPayload();
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);//获取访问器
        String user = accessor.getUser().getName();//获取CONNECT帧中验证身份时增加的用户名
        System.out.println(user);

        template.convertAndSendToUser(user, "/app/appUser", payLoad, accessor.getMessageHeaders());
    }


    /**
     * 修改头信息
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
