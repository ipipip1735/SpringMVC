package config;

import dao.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Created by Administrator on 2019/11/25 17:24.
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
//    @Bean
//    public HandlerMapping handlerMapping() {
//        System.out.println("~~handlerMapping~~");
//        Map<String, WebSocketHandler> map = new HashMap<>();
//        map.put("/wss", session -> {
//            System.out.println("~~websocket.session~~");
//            System.out.println();
//            return Mono.never();
//        });
//
//
//        int order = -1; // before annotated controllers
//
//        return new SimpleUrlHandlerMapping(map, order);
//    }

//    @Bean
//    public WebSocketHandlerAdapter handlerAdapter() {
//        System.out.println("~~handlerAdapter~~");
//
//        return new WebSocketHandlerAdapter();
//    }


//    @Bean
//    public WebSocketHandlerAdapter handlerAdapter() {
//        System.out.println("~~handlerAdapter~~");
//
//        return new WebSocketHandlerAdapter();
//    }


    @Bean
    public WebSocketHandler myHandler() {
        System.out.println("~~handlerAdapter~~");

        return new TextWebSocketHandler(){
            @Override
            protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
                System.out.println("~~handleBinaryMessage~~");
                super.handleBinaryMessage(session, message);
            }
        };
    }



    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("~~registerWebSocketHandlers~~");

        registry.addHandler(myHandler(), "/wss");
    }



//    @Bean
//    public DefaultHandshakeHandler handshakeHandler() {
//
//        WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
//        policy.setInputBufferSize(8192);
//        policy.setIdleTimeout(600000);
//
//        return new DefaultHandshakeHandler(
//                new JettyRequestUpgradeStrategy(new WebSocketServerFactory(policy)));
//    }


}
