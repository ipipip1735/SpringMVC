package controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/wsclient")
    public String wsclient() {
        return "websocket";
    }

    @GetMapping("/sockJS")
    public String sockJS() {
        return "sockJS";
    }

}
