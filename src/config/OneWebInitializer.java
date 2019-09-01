//package config;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
///**
// * Created by Administrator on 2019/8/31 8:00.
// */
//
//public class OneWebInitializer implements WebApplicationInitializer {
//    public OneWebInitializer() {
//        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
//    }
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        System.out.println("~~" + getClass().getSimpleName() + ".onStartup~~");
//
//
//        //方式一：
////        XmlWebApplicationContext root = new XmlWebApplicationContext();
////        root.setConfigLocation("/WEB-INF/one-servlet.xml");
////        root.refresh();
//
//        //方式二：
//        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
//        root.register(AppConfig.class);
//        root.refresh();
//
//
//
//        //加载分发器
//        DispatcherServlet servlet = new DispatcherServlet(root);
//        ServletRegistration.Dynamic registration = servletContext.addServlet("one", servlet);
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/one");
//
//
//        //加载监听器
//        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(root);
//        servletContext.addListener(contextLoaderListener);
//
//    }
//}
