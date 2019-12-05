package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.RequestUpgradeStrategy;
import org.springframework.web.socket.server.standard.TomcatRequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import static org.springframework.web.socket.CloseStatus.PROTOCOL_ERROR;

/**
 * Created by Administrator on 2019/12/1 17:20.
 */
@Configuration
@EnableWebSocketMessageBroker
public class STOMPConfig implements WebSocketMessageBrokerConfigurer {
    @Bean
    public DefaultHandshakeHandler handshakeHandler() {

        return new DefaultHandshakeHandler(new TomcatRequestUpgradeStrategy());
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        System.out.println("~~registerStompEndpoints~~");
        registry.addEndpoint("/ep");
//        registry.addEndpoint("/portfolio").withSockJS();


//        registry.addEndpoint("/portfolio")
//                .setHandshakeHandler(handshakeHandler())
//                .withSockJS();

    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/user");
        config.enableSimpleBroker("/ete", "/all");
    }


}
