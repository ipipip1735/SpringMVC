package config;

import filter.OneFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.io.File;

/**
 * Created by Administrator on 2019/8/31 14:12.
 */
public class OneWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public OneWebAppInitializer() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    //配置根应用上下文
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("~~" + getClass().getSimpleName() + ".getRootConfigClasses~~");

        return new Class[]{AppConfig.class};
    }

    //配置Servlet上下文
    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("~~" + getClass().getSimpleName() + ".getServletConfigClasses~~");

        return new Class[]{ServletConfig.class};
    }

    //配置URL映射
    @Override
    protected String[] getServletMappings() {
        System.out.println("~~" + getClass().getSimpleName() + ".getServletMappings~~");

        return new String[]{"/"};
    }

//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        System.out.println("~~" + getClass().getSimpleName() + ".customizeRegistration~~");
//
//
//        String TMP_FOLDER = System.getenv("CATALINA_TMPDIR");
//        int MAX_UPLOAD_SIZE = 2 * 1024;
//        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
//                TMP_FOLDER,
//                MAX_UPLOAD_SIZE,
//                MAX_UPLOAD_SIZE * 2,
//                MAX_UPLOAD_SIZE / 2);
//        registration.setMultipartConfig(multipartConfigElement);
//
//    }

//    @Override
//    protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
//        return super.getRootApplicationContextInitializers();
//    }

    //配置过滤器
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new ResourceUrlEncodingFilter()};
    }
}
