package config;

import advice.OneAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.validation.Validator;


/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller"})
public class ServletConfig{

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

//    @Bean
//    public OneAdvice oneAdvice() {
//        return new OneAdvice();
//    }

}