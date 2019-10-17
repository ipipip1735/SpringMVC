package config;

import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

/**
 * Created by Administrator on 2019/8/31 14:12.
 */
public class TwoWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public TwoWebAppInitializer() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    //配置根应用上下文
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("~~" + getClass().getSimpleName() + ".getRootConfigClasses~~");

        return null;
    }

    //配置Servlet上下文
    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("~~" + getClass().getSimpleName() + ".getServletConfigClasses~~");

        return new Class[]{TwoServletConfig.class};
    }

    //配置Servlet名
    @Override
    protected String getServletName() {
        return "twoDispatcher";
    }

    //配置Servlet加载顺序
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(-1);
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("~~" + getClass().getSimpleName() + ".getServletMappings~~");

        return new String[]{"/two/*"};
    }

    //配置过滤器
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new ResourceUrlEncodingFilter()};
    }
}
