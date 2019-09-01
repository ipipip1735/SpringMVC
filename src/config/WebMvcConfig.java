package config;

import controller.OneController;
import controller.TwoController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
public class WebMvcConfig {

    @Bean
    public OneController oneController() {
        return new OneController();
    }

    @Bean
    public TwoController twoController() {
        return new TwoController();
    }

//    @Bean
//    public OneController oneController() {
//        return new OneController();
//    }
}
