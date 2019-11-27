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
import org.springframework.web.socket.*;
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


//    @Bean
//    public WebSocketHandler myHandler() {
//        System.out.println("~~handlerAdapter~~");
//
//        return new TextWebSocketHandler(){
//            @Override
//            protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
//                System.out.println("~~handleBinaryMessage~~");
//                super.handleBinaryMessage(session, message);
//            }
//        };
//    }

    @Bean
    public WebSocketHandler myHandler() {
        System.out.println("~~handlerAdapter~~");

        WebSocketHandler handler = new WebSocketHandler(){
            @Override
            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                System.out.println("~~afterConnectionEstablished~~");

                System.out.println("getAcceptedProtocol is " + session.getAcceptedProtocol());
                System.out.println("getAttributes is " + session.getAttributes());
                System.out.println("getBinaryMessageSizeLimit is " + session.getBinaryMessageSizeLimit());
                System.out.println("getExtensions is " + session.getExtensions());
                System.out.println("getHandshakeHeaders is " + session.getHandshakeHeaders());
                System.out.println("getId is " + session.getId());
                System.out.println("getLocalAddress is " + session.getLocalAddress());
                System.out.println("getPrincipal is " + session.getPrincipal());
                System.out.println("getRemoteAddress is " + session.getRemoteAddress());
                System.out.println("getTextMessageSizeLimit is " + session.getTextMessageSizeLimit());
                System.out.println("getUri is " + session.getUri());
            }

            @Override
            public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
                System.out.println("~~handleMessage~~");

                System.out.println("getAcceptedProtocol is " + session.getAcceptedProtocol());
                System.out.println("getAttributes is " + session.getAttributes());
                System.out.println("getBinaryMessageSizeLimit is " + session.getBinaryMessageSizeLimit());
                System.out.println("getExtensions is " + session.getExtensions());
                System.out.println("getHandshakeHeaders is " + session.getHandshakeHeaders());
                System.out.println("getId is " + session.getId());
                System.out.println("getLocalAddress is " + session.getLocalAddress());
                System.out.println("getPrincipal is " + session.getPrincipal());
                System.out.println("getRemoteAddress is " + session.getRemoteAddress());
                System.out.println("getTextMessageSizeLimit is " + session.getTextMessageSizeLimit());
                System.out.println("getUri is " + session.getUri());
                System.out.println("----------");
                System.out.println("getPayload is " + message.getPayload());
                System.out.println("getPayloadLength is " + message.getPayloadLength());
                System.out.println("isLast is " + message.isLast());



            }

            @Override
            public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
                System.out.println("~~handleTransportError~~");

                System.out.println("getAcceptedProtocol is " + session.getAcceptedProtocol());
                System.out.println("getAttributes is " + session.getAttributes());
                System.out.println("getBinaryMessageSizeLimit is " + session.getBinaryMessageSizeLimit());
                System.out.println("getExtensions is " + session.getExtensions());
                System.out.println("getHandshakeHeaders is " + session.getHandshakeHeaders());
                System.out.println("getId is " + session.getId());
                System.out.println("getLocalAddress is " + session.getLocalAddress());
                System.out.println("getPrincipal is " + session.getPrincipal());
                System.out.println("getRemoteAddress is " + session.getRemoteAddress());
                System.out.println("getTextMessageSizeLimit is " + session.getTextMessageSizeLimit());
                System.out.println("getUri is " + session.getUri());
            }

            @Override
            public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
                System.out.println("~~afterConnectionClosed~~");

                System.out.println("getAcceptedProtocol is " + session.getAcceptedProtocol());
                System.out.println("getAttributes is " + session.getAttributes());
                System.out.println("getBinaryMessageSizeLimit is " + session.getBinaryMessageSizeLimit());
                System.out.println("getExtensions is " + session.getExtensions());
                System.out.println("getHandshakeHeaders is " + session.getHandshakeHeaders());
                System.out.println("getId is " + session.getId());
                System.out.println("getLocalAddress is " + session.getLocalAddress());
                System.out.println("getPrincipal is " + session.getPrincipal());
                System.out.println("getRemoteAddress is " + session.getRemoteAddress());
                System.out.println("getTextMessageSizeLimit is " + session.getTextMessageSizeLimit());
                System.out.println("getUri is " + session.getUri());
                System.out.println("----------");
                System.out.println("getCode is " + closeStatus.getCode());
                System.out.println("getReason is " + closeStatus.getReason());

            }

            @Override
            public boolean supportsPartialMessages() {
                System.out.println("~~supportsPartialMessages~~");
                return true;
            }
        };

        return handler;
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
