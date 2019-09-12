package config;

import dao.Car;
import dao.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2019/9/9 21:41.
 */
@Configuration
public class ConvertConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        System.out.println("~~" + getClass().getSimpleName() + ".addFormatters~~");


        /**
         * 格式化日期
         */
//        Formatter<Date> dateFormatter = new Formatter<Date>() {
//
//            @Override
//            public String print(Date object, Locale locale) {
//                System.out.println("~~" + getClass().getSimpleName() + ".print~~");
//                return "[Date]1970-01-01 00:00:00 UTC+8";
//            }
//
//            @Override
//            public Date parse(String text, Locale locale) throws ParseException {
//                System.out.println("~~" + getClass().getSimpleName() + ".parse~~");
//                return new Date(1501234567);
//            }
//        };
//        registry.addFormatter(dateFormatter);


        /**
         * 格式化Car对象
         */
//        Formatter<Car> carFormatter = new Formatter<>() {
//            @Override
//            public String print(Car car, Locale locale) {
//                System.out.println("~~" + getClass().getSimpleName() + ".print~~");
//                return car.toString();
//            }
//
//            @Override
//            public Car parse(String text, Locale locale) throws ParseException {
//                System.out.println("~~" + getClass().getSimpleName() + ".parse~~");
//                return new Car(12, "bob");
//            }
//        };
//        registry.addFormatter(carFormatter);


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
