package config;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Created by Administrator on 2019/10/2 5:02.
 */
public class MessageConverterConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.out.println("~~" + getClass().getSimpleName() + ".configureMessageConverters~~");


        //自定义转换器
        HttpMessageConverter<Person> personHttpMessageConverter = new HttpMessageConverter<>() {
            @Override
            public boolean canRead(Class<?> clazz, MediaType mediaType) {
                System.out.println("~~" + getClass().getSimpleName() + ".canRead~~");

                System.out.println("clazz is " + clazz);
                System.out.println("mediaType is " + mediaType);

                return true;
            }

            @Override
            public boolean canWrite(Class<?> clazz, MediaType mediaType) {
                System.out.println("~~" + getClass().getSimpleName() + ".canWrite~~");
                System.out.println("clazz is " + clazz);
                System.out.println("mediaType is " + mediaType);

                return true;
            }

            @Override
            public List<MediaType> getSupportedMediaTypes() {
                System.out.println("~~" + getClass().getSimpleName() + ".getSupportedMediaTypes~~");
                return Arrays.asList(APPLICATION_JSON);
            }

            @Override
            public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
                System.out.println("~~" + getClass().getSimpleName() + ".read~~");
                System.out.println("clazz is " + clazz);
                System.out.println("inputMessage is " + inputMessage);

                byte[] bytes = new byte[inputMessage.getBody().available()];
                inputMessage.getBody().read(bytes);
                String s = new String(bytes, UTF_8);
                System.out.println(s);

                Person person = new Person();
                System.out.println(person);
                return person;
            }

            @Override
            public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                System.out.println("~~" + getClass().getSimpleName() + ".write~~");
                System.out.println("person is " + person);
                System.out.println("contentType is " + contentType);
                System.out.println("outputMessage is " + outputMessage);

                String resulteJson = "{\"xxx\":123}";

                outputMessage.getBody().write(resulteJson.getBytes());
                outputMessage.getBody().close();
            }
        };
        converters.add(personHttpMessageConverter);





        //手动增加Spring自带信息转换器
        // 如果我们使用了自定义信息转换器,框架就不会增加自带的,所以必须手动增加
//        converters.add(new MappingJackson2HttpMessageConverter());
//        converters.add(new MappingJackson2XmlHttpMessageConverter());
//        converters.add(new FormHttpMessageConverter());
//        converters.add(new StringHttpMessageConverter());
//        converters.add(new ByteArrayHttpMessageConverter());



    }
}
