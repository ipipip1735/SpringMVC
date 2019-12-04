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
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.*;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.RequestUpgradeStrategy;
import org.springframework.web.socket.server.jetty.JettyRequestUpgradeStrategy;
import org.springframework.web.socket.server.standard.TomcatRequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.Principal;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.socket.CloseStatus.GOING_AWAY;
import static org.springframework.web.socket.CloseStatus.PROTOCOL_ERROR;

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
    public HandshakeHandler handshakeHandler() {

        //方式一：自定义
//        HandshakeHandler handshakeHandler = new HandshakeHandler() {
//            @Override
//            public boolean doHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws HandshakeFailureException {
//                System.out.println("~~doHandshake~~");
//
//                System.out.println("request is " + request);
//                System.out.println("response is " + response);
//                System.out.println("wsHandler is " + wsHandler);
//                System.out.println("attributes is " + attributes);
//
//                return true;
//            }
//        };

        //方式二：使用请求策略
        RequestUpgradeStrategy requestUpgradeStrategy = new TomcatRequestUpgradeStrategy();//使用TomCat策略对象的




        DefaultHandshakeHandler handshakeHandler = new DefaultHandshakeHandler(requestUpgradeStrategy);


        return handshakeHandler;
    }


    @Bean
    public WebSocketHandler myHandler() {
        System.out.println("~~myHandler~~");


        //方式一：自定义处理器
//        WebSocketHandler handler = new WebSocketHandler() {
//            @Override
//            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//                System.out.println("~~afterConnectionEstablished~~");
//
//                System.out.println("getAcceptedProtocol is " + session.getAcceptedProtocol());
//                System.out.println("getAttributes is " + session.getAttributes());
//                System.out.println("getBinaryMessageSizeLimit is " + session.getBinaryMessageSizeLimit());
//                System.out.println("getExtensions is " + session.getExtensions());
//                System.out.println("getHandshakeHeaders is " + session.getHandshakeHeaders());
//                System.out.println("getId is " + session.getId());
//                System.out.println("getLocalAddress is " + session.getLocalAddress());
//                System.out.println("getPrincipal is " + session.getPrincipal());
//                System.out.println("getRemoteAddress is " + session.getRemoteAddress());
//                System.out.println("getTextMessageSizeLimit is " + session.getTextMessageSizeLimit());
//                System.out.println("getUri is " + session.getUri());
//            }
//
//            @Override
//            public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//                System.out.println("~~handleMessage~~");
//
//                System.out.println("getAcceptedProtocol is " + session.getAcceptedProtocol());
//                System.out.println("getAttributes is " + session.getAttributes());
//                System.out.println("getBinaryMessageSizeLimit is " + session.getBinaryMessageSizeLimit());
//                System.out.println("getExtensions is " + session.getExtensions());
//                System.out.println("getHandshakeHeaders is " + session.getHandshakeHeaders());
//                System.out.println("getId is " + session.getId());
//                System.out.println("getLocalAddress is " + session.getLocalAddress());
//                System.out.println("getPrincipal is " + session.getPrincipal());
//                System.out.println("getRemoteAddress is " + session.getRemoteAddress());
//                System.out.println("getTextMessageSizeLimit is " + session.getTextMessageSizeLimit());
//                System.out.println("getUri is " + session.getUri());
//                System.out.println("----------");
//                System.out.println("getPayload is " + message.getPayload());
//                System.out.println("getPayloadLength is " + message.getPayloadLength());
//                System.out.println("isLast is " + message.isLast());
//
//                if (message.getPayload().equals("close")) {
//                    CloseStatus status = PROTOCOL_ERROR.withReason("yyyy");
//                    session.close(status);
//                    System.out.println("closing");
//                } else {
//                    String s = "server|" + message.getPayload();
//                    System.out.println(s);
//                    session.sendMessage(new TextMessage(s));
//                }
//
//            }
//
//            @Override
//            public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
//                System.out.println("~~handleTransportError~~");
//
//                System.out.println("getAcceptedProtocol is " + session.getAcceptedProtocol());
//                System.out.println("getAttributes is " + session.getAttributes());
//                System.out.println("getBinaryMessageSizeLimit is " + session.getBinaryMessageSizeLimit());
//                System.out.println("getExtensions is " + session.getExtensions());
//                System.out.println("getHandshakeHeaders is " + session.getHandshakeHeaders());
//                System.out.println("getId is " + session.getId());
//                System.out.println("getLocalAddress is " + session.getLocalAddress());
//                System.out.println("getPrincipal is " + session.getPrincipal());
//                System.out.println("getRemoteAddress is " + session.getRemoteAddress());
//                System.out.println("getTextMessageSizeLimit is " + session.getTextMessageSizeLimit());
//                System.out.println("getUri is " + session.getUri());
//            }
//
//            @Override
//            public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
//                System.out.println("~~afterConnectionClosed~~");
//
//                System.out.println("getAcceptedProtocol is " + session.getAcceptedProtocol());
//                System.out.println("getAttributes is " + session.getAttributes());
//                System.out.println("getBinaryMessageSizeLimit is " + session.getBinaryMessageSizeLimit());
//                System.out.println("getExtensions is " + session.getExtensions());
//                System.out.println("getHandshakeHeaders is " + session.getHandshakeHeaders());
//                System.out.println("getId is " + session.getId());
//                System.out.println("getLocalAddress is " + session.getLocalAddress());
//                System.out.println("getPrincipal is " + session.getPrincipal());
//                System.out.println("getRemoteAddress is " + session.getRemoteAddress());
//                System.out.println("getTextMessageSizeLimit is " + session.getTextMessageSizeLimit());
//                System.out.println("getUri is " + session.getUri());
//                System.out.println("----------");
//                System.out.println("getCode is " + closeStatus.getCode());
//                System.out.println("getReason is " + closeStatus.getReason());
//
//            }
//
//            @Override
//            public boolean supportsPartialMessages() {
//                System.out.println("~~supportsPartialMessages~~");
//                return true;
//            }
//        };

        //方式二：使用Spring内置的处理器
        TextWebSocketHandler handler = new TextWebSocketHandler() {
            @Override
            protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
                System.out.println("~~handleTextMessage~~");
                System.out.println("session is " + session);
                System.out.println("message is " + message.getPayloadLength());

                if (message.getPayload().equals("close")) {
                    CloseStatus status = PROTOCOL_ERROR.withReason("yyyy");//设置状态码和对应的详细信息
                    session.close(status);//关闭连接
                    System.out.println("closing");
                } else {
                    String s = "server|" + message.getPayload();//获取客户端发送的信息
                    System.out.println(s);
                    session.sendMessage(new TextMessage(s));//给客户端回应信息

                    //服务端持续发送信息
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                for (int i = 0; i < 2; i++) {
//                                    Thread.sleep(3000L);
//                                    session.sendMessage(new TextMessage(s));//WebSocket是双向通信，服务端可以随时发送信息
//                                }
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();
                }

            }

        };

        return handler;
    }


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("~~registerWebSocketHandlers~~");

        //使用WebSocket
        registry.addHandler(myHandler(), "/wss");//注册处理器，绑定处理器路由

//        registry.addHandler(myHandler(), "/wss")
//                .setHandshakeHandler(handshakeHandler());//设置握手处理器



        //使用SockJS
//        registry.addHandler(myHandler(), "/skJS")
//                .withSockJS()
//                .setWebSocketEnabled(false);





    }


}
