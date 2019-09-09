package config;

import binder.OnePropertyEditorRegistrar;
import binder.PersonConverter;
import controller.OneController;
import controller.TwoController;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@Import(ConvertConfig.class)
@ComponentScan(basePackages = {"service"})
public class AppConfig {

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();

        PropertyEditorRegistrar[] propertyEditorRegistrars = new PropertyEditorRegistrar[]{
                onePropertyEditorRegistrar()//注册登记员
        };
        customEditorConfigurer.setPropertyEditorRegistrars(propertyEditorRegistrars);
        return customEditorConfigurer;
    }


    @Bean
    OnePropertyEditorRegistrar onePropertyEditorRegistrar() {
        return new OnePropertyEditorRegistrar();//自定义登记员
    }


    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();

        Set set = new HashSet();
        set.add(new PersonConverter());

        conversionServiceFactoryBean.setConverters(set);

        return conversionServiceFactoryBean;
    }

}
