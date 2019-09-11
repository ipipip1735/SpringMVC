package config;

import binder.OnePropertyEditorRegistrar;
import binder.PersonConverter;
import binder.TwoPropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019/9/11 11:44.
 */
@Configuration
public class PropertyEditorConfig {
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

}
