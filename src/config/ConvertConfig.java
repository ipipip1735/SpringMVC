package config;

import dao.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Administrator on 2019/9/9 21:41.
 */
@Configuration
public class ConvertConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        System.out.println("~~" + getClass().getSimpleName() + ".addFormatters~~");


        //
        Formatter formatter = new Formatter() {
            @Override
            public Object parse(String text, Locale locale) throws ParseException {
                System.out.println("~~" + getClass().getSimpleName() + ".parse~~");

                System.out.println(this);
                return null;
            }

            @Override
            public String print(Object object, Locale locale) {
                System.out.println("~~" + getClass().getSimpleName() + ".print~~");

                System.out.println(this);
                return null;
            }
        };
        registry.addFormatter(formatter);


        //注册类型转换工具
//        Converter<String, Person> converter = new Converter<String, Person>() {
//            @Override
//            public Person convert(String source) {
//                System.out.println("~~" + getClass().getSimpleName() + ".convert~~");
//                System.out.println(this);
//
//                System.out.println("source is " + source);
//
//                Person person = new Person();
//                System.out.println(person);
//                return person;
//            }
//        };
//        registry.addConverter(converter);
    }

}
