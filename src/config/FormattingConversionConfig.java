package config;

import binder.StudentAnnotationFormatterFactory;
import binder.StudentFormat;
import dao.Car;
import dao.Person;
import dao.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.*;
import org.springframework.format.Formatter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Time;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Administrator on 2019/9/9 21:41.
 */

/**
 * 方式一：实现WebMvcConfigurer接口
 * 此方式需要增加@EnableWebMvc，一个就可以了，随便在哪个配置对象上增加
 */
@Configuration
public class FormattingConversionConfig implements WebMvcConfigurer {
    public FormattingConversionConfig() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    /**
     * FormatterRegistry接口是ConverterRegistry接口的子类接口
     * 也就是说，格式化是类型转换的特例
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        System.out.println("~~" + getClass().getSimpleName() + ".addFormatters~~");


        /**
         * 格式化任意对象
         * 将任意对象格式化为所需字符串
         */
        //例一：Bean格式化
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

        //例二：注册自定义格式化工具
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
//                return new Date(Long.valueOf(text));//将时间戳转换为日期
//            }
//        };
//        registry.addFormatter(dateFormatter);



        //例三：注册自定义注解格式化工具
//        registry.addFormatterForFieldAnnotation(new StudentAnnotationFormatterFactory());
//        registry.addFormatterForFieldAnnotation(new DateTimeFormatAnnotationFormatterFactory());//增加Annotation转换（不需要增加，系统已经增加了，这里是为了演示）



        //例四：使用Spring自带的格式化工具
//        registry.addFormatter(new DateFormatter("yyyyMM"));//Spring自带的格式化工具
//        registry.addFormatterForFieldType(Date.class, new DateFormatter("yyyyMM"));//限定控制器的参数类型


        System.out.println(registry);//打印最后注册器中包含的转换器和格式化工具





        /*注册类型转换工具*/
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


/**
 * 方式二：重写WebMvcConfigurationSupport对象
 */
//@Configuration
//public class FormatterConfig extends WebMvcConfigurationSupport {
//    public FormatterConfig() {
//        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
//    }
//
//    @Override
//    public FormattingConversionService mvcConversionService() {
//        System.out.println("~~" + getClass().getSimpleName() + ".mvcConversionService~~");
//
//
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
////
////        // Ensure @NumberFormat is still supported
////        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
////
////        //Register date conversion with a specific global format
////        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
////        registrar.setFormatter(new DateFormatter("yyyyMM"));
////        registrar.registerFormatters(conversionService);
//////        conversionService.addFormatterForFieldAnnotation(new DateTimeFormatAnnotationFormatterFactory());
//
//
//        return conversionService;
//    }
//}