package config;

import dao.Car;
import dao.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Time;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
         * 格式化任意日期
         * 将字符串转换为日期
         */
        registry.addFormatter(new DateFormatter("yyyyMM"));
        registry.addFormatterForFieldType(Date.class, new DateFormatter("yyyyMM"));
//        registry.addFormatterForFieldAnnotation();







        /**
         * 格式化任意对象
         * 将任意对象格式化为所需字符串
         */
        //Bean格式化
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
//        registry.addFormatter(carFormatter);//注册

        //日期格式化
//        Formatter<Date> dateFormatter = new Formatter<Date>() {
//
//            @Override
//            public String print(Date object, Locale locale) {
//                System.out.println("~~" + getClass().getSimpleName() + ".print~~");
//                return object.toString();
//            }
//
//            @Override
//            public Date parse(String text, Locale locale) throws ParseException {
//                System.out.println("~~" + getClass().getSimpleName() + ".parse~~");
//                System.out.println("text is " + text);
//                return new Date(Long.valueOf(text));
//            }
//        };
//        registry.addFormatter(dateFormatter);//注册






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
