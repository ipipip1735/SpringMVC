package config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.ExecutorSubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.web.socket.CloseStatus.PROTOCOL_ERROR;

/**
 * Created by Administrator on 2019/12/1 17:20.
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {
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
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/topic/", "/queue/");
    }

    //增加输出通道拦截器
    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                System.out.println("~~OutboundChannel-preSend~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);

                //增加拦截器
//                ExecutorSubscribableChannel esc = (ExecutorSubscribableChannel) channel;
//                esc.addInterceptor(null);

                return message;
//                return null;//拦截信息，即不发送信息给控制器或中间人
            }

            @Override
            public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
                System.out.println("~~OutboundChannel-postSend~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
                System.out.println("sent is " + sent);

                //如果是MESSAGE帧就写日志
                if(StompHeaderAccessor.wrap(message).getCommand() == StompCommand.MESSAGE){
                    ExecutorSubscribableChannel esc = (ExecutorSubscribableChannel) channel;
                    esc.getLogger().info("xxxxxxxxxxx");
                }
            }

            @Override
            public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
                System.out.println("~~OutboundChannel-afterSendCompletion~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
                System.out.println("sent is " + sent);

            }

            @Override
            public boolean preReceive(MessageChannel channel) {
                System.out.println("~~OutboundChannel-preReceive~~");
                System.out.println("channel is " + channel);
                return true;
            }

            @Override
            public Message<?> postReceive(Message<?> message, MessageChannel channel) {
                System.out.println("~~OutboundChannel-postReceive~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
                return message;
            }

            @Override
            public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
                System.out.println("~~OutboundChannel-afterReceiveCompletion~~");
                System.out.println("message is " + message);
            }
        });
    }

    //增加输入通道拦截器
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                System.out.println("~~InboundChannel-preSend~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);

                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
                accessor.setHeader("xxx", "yyy");
                message = MessageBuilder.createMessage(message.getPayload(), accessor.getMessageHeaders());

                return message;
            }

            @Override
            public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
                System.out.println("~~InboundChannel-postSend~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
            }

            @Override
            public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
                System.out.println("~~InboundChannel-afterSendCompletion~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
                System.out.println("sent is " + sent);

            }

            @Override
            public boolean preReceive(MessageChannel channel) {
                System.out.println("~~InboundChannel-preReceive~~");
                System.out.println("channel is " + channel);
                return true;
            }

            @Override
            public Message<?> postReceive(Message<?> message, MessageChannel channel) {
                System.out.println("~~InboundChannel-postReceive~~");
                System.out.println("message is " + message);
                System.out.println("channel is " + channel);
                return message;
            }

            @Override
            public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
                System.out.println("~~InboundChannel-afterReceiveCompletion~~");
                System.out.println("message is " + message);
            }
        });
    }


    //增加转换器
//    @Override
//    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
//        messageConverters.add(new MessageConverter() {
//            @Override
//            public TextMessage fromMessage(Message<?> message, Class<?> targetClass) {
//                System.out.println("~~fromMessage~~");
//                System.out.println("message is " + message);
//                System.out.println("targetClass is " + targetClass);
//
//                return new TextMessage(new String((byte[]) message.getPayload(), UTF_8));
//            }
//
//            @Override
//            public Message<?> toMessage(Object payload, MessageHeaders headers) {
//                System.out.println("~~toMessage~~");
//                System.out.println("payload is " + payload);
//                System.out.println("headers is " + headers);
//                return null;
//            }
//        });
//        return true;//返回true表示可以和Spring默认转换器共同时，优先使用默认转换器
//    }

    //增加事件
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

    //增加事件
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

    //增加事件
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


    //增加事件
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

    //增加事件
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
