package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2019/9/9 21:41.
 */
@Configuration
public class FormatterConfig extends WebMvcConfigurationSupport {
    public FormatterConfig() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public FormattingConversionService mvcConversionService() {
//        return super.mvcConversionService();

        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        // Ensure @NumberFormat is still supported
        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());

        //Register date conversion with a specific global format
        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter("yyyyMM"));
        registrar.registerFormatters(conversionService);
//        conversionService.addFormatterForFieldAnnotation(new DateTimeFormatAnnotationFormatterFactory());


        return conversionService;
//        return null;
    }
}


//@Configuration
//public class FormatterConfig {
//
//    @Bean
//    public FormattingConversionService conversionService() {
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
//
//        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
//
//        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
//        registrar.setFormatter(new DateFormatter("yyyyMMdd"));
//        registrar.registerFormatters(conversionService);
//
//
////        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
////        registrar.setDateFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
////        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy_HH:mm:ss"));
////        registrar.registerFormatters(conversionService);
//
//        // other desired formatters
//        return conversionService;
//    }
//
//}
