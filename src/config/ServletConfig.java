package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller"})
@Import(StompConfig.class)//配置STOMP
public class ServletConfig{

    @Bean
    public InternalResourceViewResolver viewResolver() {
        System.out.println("~~" + getClass().getSimpleName() + ".viewResolver~~");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("messages");
        return resourceBundleMessageSource;
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
//     * Apache通用上传组件
//     */
//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(100000);
//
//        try {
//            multipartResolver.setUploadTempDir(new FileSystemResource(System.getenv("CATALINA_TMPDIR")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return multipartResolver;
//    }


    //使用Servlet 3.0标准
//    @Bean
//    public StandardServletMultipartResolver multipartResolver() {
//        StandardServletMultipartResolver standardServletMultipartResolver = new StandardServletMultipartResolver();
//        return standardServletMultipartResolver;
//    }


}