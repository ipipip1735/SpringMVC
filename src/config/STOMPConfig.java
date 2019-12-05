package config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.messaging.*;
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
        config.setApplicationDestinationPrefixes("/ctl");
        config.enableSimpleBroker("/ete", "/all");
    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                System.out.println("~~preSend~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
                return message;
            }

            @Override
            public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
                System.out.println("~~postSend~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
            }

            @Override
            public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
                System.out.println("~~afterSendCompletion~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
                System.out.println("sent is " + sent);

            }

            @Override
            public boolean preReceive(MessageChannel channel) {
                System.out.println("~~preReceive~~");
                System.out.println("channel is " + channel);
                return true;
            }

            @Override
            public Message<?> postReceive(Message<?> message, MessageChannel channel) {
                System.out.println("~~postReceive~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
                return message;
            }

            @Override
            public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
                System.out.println("~~afterReceiveCompletion~~");
                System.out.println("message is " + message);
            }
        });
    }


    @Bean
    public ApplicationListener<BrokerAvailabilityEvent> availabilityEventApplicationListener() {

        return new ApplicationListener<BrokerAvailabilityEvent>() {
            @Override
            public void onApplicationEvent(BrokerAvailabilityEvent event) {
                System.out.println("~~onApplicationEvent~~");
                System.out.println("event is " + event);
            }
        };
    }

    @Bean
    public ApplicationListener<SessionConnectEvent> sessionConnectEventApplicationListener() {
        return new ApplicationListener<SessionConnectEvent>() {
            @Override
            public void onApplicationEvent(SessionConnectEvent event) {
                System.out.println("~~onApplicationEvent-SessionConnectEvent~~");
                System.out.println("event is " + event);
            }
        };
    }

    @Bean
    public ApplicationListener<SessionConnectedEvent> sessionConnectedEventApplicationListener() {
        return new ApplicationListener<SessionConnectedEvent>() {
            @Override
            public void onApplicationEvent(SessionConnectedEvent event) {
                System.out.println("~~onApplicationEvent-SessionConnectedEvent~~");
                System.out.println("event is " + event);
            }
        };
    }


    @Bean
    public ApplicationListener<SessionDisconnectEvent> sessionDisconnectEventApplicationListener() {
        return new ApplicationListener<SessionDisconnectEvent>() {
            @Override
            public void onApplicationEvent(SessionDisconnectEvent event) {
                System.out.println("~~onApplicationEvent-SessionDisconnectEvent~~");
                System.out.println("event is " + event);
            }
        };
    }

    @Bean
    public ApplicationListener<SessionSubscribeEvent> sessionSubscribeEventApplicationListener() {
        return new ApplicationListener<SessionSubscribeEvent>() {
            @Override
            public void onApplicationEvent(SessionSubscribeEvent event) {
                System.out.println("~~onApplicationEvent-SessionSubscribeEvent~~");
                System.out.println("event is " + event);
            }
        };
    }

    @Bean
    public ApplicationListener<SessionUnsubscribeEvent> sessionUnsubscribeEventApplicationListener() {
        return new ApplicationListener<SessionUnsubscribeEvent>() {
            @Override
            public void onApplicationEvent(SessionUnsubscribeEvent event) {
                System.out.println("~~onApplicationEvent-SessionUnsubscribeEvent~~");
                System.out.println("event is " + event);
            }
        };
    }


}
