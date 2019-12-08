package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2019/11/25 16:01.
 */
@Controller
public class WebSocketController {

    @GetMapping("/websocket")
    public String wsclient() {
        return "websocket";
    }

    @GetMapping("/sockJS")
    public String sockJS() {
        return "sockJS";
    }

    @GetMapping("/stompJS")
    public String stompJS() {
        return "stomp";
    }
}
