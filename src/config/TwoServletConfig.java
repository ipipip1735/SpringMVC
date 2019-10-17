package config;

import controller.TwoController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@EnableWebMvc
public class TwoServletConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        System.out.println("~~" + getClass().getSimpleName() + ".viewResolver~~");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Bean
    TwoController twoController() {
        return new TwoController();
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