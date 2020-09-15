package config;

import filter.OneFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/8/31 14:12.
 */
public class OneWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public OneWebAppInitializer() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    //配置应用上下文
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("~~" + getClass().getSimpleName() + ".getRootConfigClasses~~");

        return new Class[]{AppConfig.class};
    }


    //配置应用上下文初始化对象
    @Override
    protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
        System.out.println("~~" + getClass().getSimpleName() + ".getRootApplicationContextInitializers~~");

        ApplicationContextInitializer applicationContextInitializer = new ApplicationContextInitializer() {
            @Override
            public void initialize(ConfigurableApplicationContext applicationContext) {
                System.out.println("~~ApplicationContextInitializer.initialize~~");


                //使用反射获取应用上下文常量
                for (Field field : applicationContext.getClass().getFields()) {
                    try {
                        System.out.println(field.getName() + " is " + field.get(null));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }


                //获取上下文信息
                System.out.println("getEnvironment is " + applicationContext.getEnvironment());
                System.out.println("getParent is " + applicationContext.getParent());
                System.out.println("getId is " + applicationContext.getId());
                System.out.println("getDisplayName is " + applicationContext.getDisplayName());
                System.out.println("getApplicationName is " + applicationContext.getApplicationName());
                System.out.println("getStartupDate is " + applicationContext.getStartupDate());
                System.out.println("getClassLoader is " + applicationContext.getClassLoader());
                System.out.println("isRunning is " + applicationContext.isRunning());
                System.out.println("isActive is " + applicationContext.isActive());

                //下面的方法一调用就报错
//                System.out.println("isSingleton is " + applicationContext.isSingleton());
//                System.out.println("isPrototype is " + applicationContext.isPrototype());
//                System.out.println("isTypeMatch is " + applicationContext.isTypeMatch());
//                System.out.println("getAutowireCapableBeanFactory is " + applicationContext.getAutowireCapableBeanFactory());
//                System.out.println("getParentBeanFactory is " + applicationContext.getParentBeanFactory());
//                System.out.println("getBeanFactory is " + applicationContext.getBeanFactory());
//                System.out.println("getBeanDefinitionCount is " + applicationContext.getBeanDefinitionCount());
//                System.out.println("getBeanDefinitionNames is " + applicationContext.getBeanDefinitionNames());
//                System.out.println("getBeanNamesForType is " + applicationContext.getBeanNamesForType());
//                System.out.println("getBeanNamesForAnnotation is " + applicationContext.getBeanNamesForAnnotation());
//                System.out.println("getBeansWithAnnotation is " + applicationContext.getBeansWithAnnotation());
//                System.out.println("getBeansOfType is " + applicationContext.getBeansOfType());
//                System.out.println("getType is " + applicationContext.getType());
//                System.out.println("getAliases is " + applicationContext.getAliases());
//                System.out.println("getBean is " + applicationContext.getBean());
//                System.out.println("getBeanProvider is " + applicationContext.getBeanProvider());
//                System.out.println("getMessage is " + applicationContext.getMessage());
//                System.out.println("getResources is " + applicationContext.getResources());
//                System.out.println("getResource is " + applicationContext.getResource());


                //通过注解查找Bean
//                applicationContext.findAnnotationOnBean("xx", Bean.class);

                //是否包含Bean
//                applicationContext.containsBeanDefinition("xx");
//                applicationContext.containsLocalBean ("xx");


                //打开/关闭上下文
//                applicationContext.start();
//                applicationContext.stop();


                //发送事件
//                applicationContext.publishEvent(new ApplicationEvent("XX") {
//                    @Override
//                    public Object getSource() {
//                        return super.getSource();
//                    }
//                });


            }
        };




//        for (Method method : ConfigurableApplicationContext.class.getMethods()) {
//            System.out.println(method.getName() + " is " + method.getName());
//        }


        return new ApplicationContextInitializer[]{applicationContextInitializer};
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

    //配置Servlet名
//    @Override
//    protected String getServletName() {
//        return "onedispatcher";
//    }


    //配置Servlet加载顺序
//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        registration.setLoadOnStartup(-1);
//    }


    //注册组件
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
//        registration.setMultipartConfig(multipartConfigElement);//设置复合上传配置对象
//
//    }


    //配置过滤器
//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[]{new ResourceUrlEncodingFilter()};
//    }
}
