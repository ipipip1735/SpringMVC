package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Administrator on 2019/8/31 14:12.
 */
public class OneWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public OneWebAppInitializer() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("~~" + getClass().getSimpleName() + ".getRootConfigClasses~~");

        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("~~" + getClass().getSimpleName() + ".getServletConfigClasses~~");

        return new Class[]{ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("~~" + getClass().getSimpleName() + ".getServletMappings~~");

        return new String[]{"/"};
    }
}
