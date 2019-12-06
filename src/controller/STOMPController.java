package controller;

import org.springframework.messaging.Message;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2019/12/6 17:02.
 */
@RestController
public class STOMPController {

    @MessageMapping("/something")
    @SendTo("/topic/something")
    public Message appSend(Message message) {
        System.out.println("~~appSend~~");

        return message;
    }

    @SubscribeMapping("/something")
    public String sub(Message message) {
        System.out.println("~~sub~~");
        return "sub";
        
    }


}
