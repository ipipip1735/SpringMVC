package config;

import binder.OnePropertyEditorRegistrar;
import controller.OneController;
import controller.TwoController;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@ComponentScan(basePackages = {"service"})
public class AppConfig {

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();

        PropertyEditorRegistrar[] propertyEditorRegistrars = new PropertyEditorRegistrar[]{
                onePropertyEditorRegistrar()
        };
        customEditorConfigurer.setPropertyEditorRegistrars(propertyEditorRegistrars);
        return customEditorConfigurer;
    }


    @Bean
    OnePropertyEditorRegistrar onePropertyEditorRegistrar() {
        return new OnePropertyEditorRegistrar();
    }



}
