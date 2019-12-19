package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.config.SimpleBrokerRegistration;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.*;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
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

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.web.socket.CloseStatus.PROTOCOL_ERROR;

/**
 * Created by Administrator on 2019/12/1 17:20.
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {


//    @Bean
//    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public List<String> stringList() {
//        return Arrays.asList("one");
//    }


    @Bean
    public DefaultHandshakeHandler handshakeHandler() {
        return new DefaultHandshakeHandler(new TomcatRequestUpgradeStrategy());
    }

    @Bean
    public TaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
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
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {

        MessageConverter messageConverter = new MessageConverter() {
            @Override
            public Object fromMessage(Message<?> message, Class<?> targetClass) {
                System.out.println("~~fromMessage~~");
                System.out.println("message is " + message);
                System.out.println("targetClass is " + targetClass);

                return "OK";
            }

            @Override
            public Message<?> toMessage(Object payload, MessageHeaders headers) {
                System.out.println("~~toMessage~~");
                System.out.println("payload is " + payload);
                System.out.println("headers is " + headers);

                return new GenericMessage<String>(payload.toString(), headers);
            }
        };
//        messageConverters.add(messageConverter);//增加转换器（服务端转换器和客户端转换器是独立的）
        return true;
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");

        registry.enableSimpleBroker("/topic/something", "/queue/something")
//        registry.enableSimpleBroker("/sgl")
//        registry.enableSimpleBroker("/ooo")
//        registry.enableSimpleBroker("/app/appUser")
//        registry.enableSimpleBroker("/topic/appSendOne")
//        registry.enableSimpleBroker("/queue/appSendOne")

//        .setTaskScheduler(taskScheduler())//配置心跳计划任务器
        .setHeartbeatValue(new long[] {0, 0});

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

                //验证用户
//                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
//                if (StompCommand.CONNECT.equals(accessor.getCommand())){
//                    String login = accessor.getLogin();
//                    String passcode = accessor.getPasscode();
//                    System.out.println(">>>>>>>>" + login + "-" + passcode);
//                    String user = "TTT";//设置用户名（一步是异步查询数据完成）
//                    accessor.setUser(new Principal() {
//                        @Override
//                        public String getName() {
//                            System.out.println(":::::::::::::getName:::::::::::::");
//                            return user;
//                        }
//                    });
//                }

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
