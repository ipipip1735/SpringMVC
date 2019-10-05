package config;

import advice.OneAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.validation.Validator;


/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller"})
public class ServletConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        System.out.println("~~" + getClass().getSimpleName() + ".viewResolver~~");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    /**
     * 基于注解的验证
     * 此Bean加不加都一样
     */
//    @Bean
//    public Validator localValidatorFactoryBean() {
//        System.out.println("~~" + getClass().getSimpleName() + ".localValidatorFactoryBean~~");
//
//        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
//        return localValidatorFactoryBean;
//    }


//    /**
//     * 建言控制器
//     */
//    @Bean
//    public OneAdvice oneAdvice() {
//        return new OneAdvice();
//    }


//    /**
//     * 上传转换器
//     */
//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(100000);
//        return multipartResolver;
//    }

    //使用Servlet 3.0标准
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        StandardServletMultipartResolver standardServletMultipartResolver = new StandardServletMultipartResolver();
//        standardServletMultipartResolver
        return standardServletMultipartResolver;
    }


}