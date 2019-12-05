package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2019/11/25 16:01.
 */
@Controller
public class WebSocketController {

//    @GetMapping("/websocket")
//    public String wsclient() {
//        return "websocket";
//    }
//
//    @GetMapping("/sockJS")
//    public String sockJS() {
//        return "sockJS";
//    }
//
//    @GetMapping("/stomp")
//    public String stomp() {
//        return "stomp";
//    }


    @MessageMapping("/cc")
    public Message ctl(Message message) {
        System.out.println("~~cc~~");

        return message;
    }

//    @SubscribeMapping("/queue/12")
//    public String sub(Message message) {
//        System.out.println("~~sub~~");
//        return "sub";
//    }


}
