package config;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Administrator on 2019/10/11 10:21.
 */
public class DefaultServletConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("~~" + getClass().getSimpleName() + ".configureDefaultServletHandling~~");

        configurer.enable();
    }
}
