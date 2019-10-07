package config;

import dao.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Created by Administrator on 2019/10/7 12:21.
 */
public class CORSConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/index")
//                .allowedOrigins("*")
//                .allowedHeaders("Access-Control-Allow-Origin", "*")
//                .allowedMethods("GET", "POST");
//    }
}
