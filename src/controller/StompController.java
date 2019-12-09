package controller;

import dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.*;
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


    @GetMapping("/stomp")
    public String stomp() {

        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());
//        stompClient.setTaskScheduler(taskScheduler);

        String url = "ws://192.168.0.126:8080/ep";
        StompSessionHandler sessionHandler = new StompSessionHandlerAdapter() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                System.out.println("~~controller|send - getPayloadType~~");
                System.out.println("headers is " + headers);
                return String.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                System.out.println("~~controller|send - handleFrame~~");
                System.out.println("headers is " + headers);
                System.out.println("payload is " + payload);

            }

            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                System.out.println("~~controller|send - afterConnected~~");
                System.out.println("session is " + session);
                System.out.println("connectedHeaders is " + connectedHeaders);

//                StompController.this.session = session;

                session.subscribe("/topic/something", new StompFrameHandler() {

                    @Override
                    public Type getPayloadType(StompHeaders headers) {
                        System.out.println("~~controller|subscribe - getPayloadType~~");
                        System.out.println("headers is " + headers);
                        return String.class;
                    }

                    @Override
                    public void handleFrame(StompHeaders headers, Object payload) {
                        System.out.println("~~controller|subscribe - handleFrame~~");
                        System.out.println("headers is " + headers);
                        System.out.println("payload is " + payload);
                    }

                });


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 0; i < 2; i++) {
                                Thread.sleep(2000L);
                                System.out.println("---------send-" + i +"--------");
                                session.send("/app/something", "payload99999");
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }

            @Override
            public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
                System.out.println("~~controller|send - handleException~~");
                System.out.println("session is " + session);
                System.out.println("command is " + command);
                System.out.println("headers is " + headers);
                System.out.println("payload is " + payload);

            }

            @Override
            public void handleTransportError(StompSession session, Throwable exception) {
                System.out.println("~~controller|send - handleTransportError~~");
                System.out.println("session is " + session);
                System.out.println("exception is " + exception);
            }
        };
        stompClient.connect(url, sessionHandler);


        return "stompSub";
    }


    @MessageMapping("/appSendOne")
    @SendTo("/topic/something")
    public TextMessage appSend(Message<String> stringMessage) {
        System.out.println("~~controller|appSendOne~~");
        System.out.println("stringMessage" + stringMessage);

        String payLoad = "Server|" + stringMessage.getPayload();
        return new TextMessage(payLoad);
    }

    @MessageMapping("/appSendTwo")
    public void appSend(TextMessage textMessage) {
        System.out.println("~~controller|appSendTwo~~");
        String payLoad = "Server|" + textMessage.getPayload();
        this.template.convertAndSend("/topic/something", new Person());
    }

    @SubscribeMapping("/sub")
    public TextMessage appSub(Message message) {
        System.out.println("~~controller|appSub~~");
        return new TextMessage("ok");
    }


}
