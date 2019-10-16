package config;

import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Administrator on 2019/10/17 5:28.
 */
public class ViewControllerConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("~~" + getClass().getSimpleName() + ".addViewControllers~~");
        registry.setOrder(-1);
        registry.addViewController("/home").setViewName("home");

    }

}
