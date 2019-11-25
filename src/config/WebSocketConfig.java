package config;

import dao.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
public class WebSocketConfig implements WebMvcConfigurer {
    @Bean
    public HandlerMapping handlerMapping() {
        System.out.println("~~handlerMapping~~");
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/wss", session -> {
            System.out.println("~~websocket.session~~");
            System.out.println();
            return Mono.never();
        });


        int order = -1; // before annotated controllers

        return new SimpleUrlHandlerMapping(map, order);
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        System.out.println("~~handlerAdapter~~");

        return new WebSocketHandlerAdapter();
    }
}
