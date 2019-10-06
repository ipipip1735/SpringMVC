package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Administrator on 2019/8/31 8:00.
 */
public class OneWebInitializer implements WebApplicationInitializer {
    public OneWebInitializer() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("~~" + getClass().getSimpleName() + ".onStartup~~");

//        xml(servletContext);
//        annotation(servletContext);

    }


    private void annotation(ServletContext servletContext) {

        AnnotationConfigWebApplicationContext rootAC = new AnnotationConfigWebApplicationContext();
        rootAC.register(AppConfig.class);
        rootAC.refresh();

        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootAC);
        servletContext.addListener(contextLoaderListener);


        AnnotationConfigWebApplicationContext servletAC = new AnnotationConfigWebApplicationContext();
        servletAC.register(ServletConfig.class);
//        servletAC.refresh(); //一用就报错，因为框架后面会自动刷新，而refresh()不能执行两次，否则报错

        DispatcherServlet servlet = new DispatcherServlet(servletAC);
        ServletRegistration.Dynamic registration = servletContext.addServlet("one", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }

    private void xml(ServletContext servletContext) {

        //加载应用上下文
        XmlWebApplicationContext rootXML = new XmlWebApplicationContext();
        rootXML.setConfigLocation("/WEB-INF/applicationContext.xml");

        //加载监听器
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootXML);
        servletContext.addListener(contextLoaderListener);


        //加载Servlet上下文
        XmlWebApplicationContext servletXML = new XmlWebApplicationContext();
        servletXML.setConfigLocation("/WEB-INF/one-servlet.xml");

        //加载分发器
        DispatcherServlet servlet = new DispatcherServlet(servletXML);
        ServletRegistration.Dynamic registration = servletContext.addServlet("one", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
