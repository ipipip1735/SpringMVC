package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2019/10/8 23:10.
 */
@Configuration
@PropertySource("classpath:ppp.properties")
public class ResourcesConfig implements WebMvcConfigurer {

    @Value("${app.version}")
    String version;

    //配置静态资源
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println("~~" + getClass().getSimpleName() + ".addResourceHandlers~~");
//
//        registry.addResourceHandler("/res/**")
//                .addResourceLocations("/cc/")
//                .setCachePeriod(365 * 24 * 3600);
//    }

    //配置静态资源，增加资源链
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("~~" + getClass().getSimpleName() + ".addResourceHandlers~~");


        //方式一：自定义解析器
        ResourceResolver resourceResolver = new ResourceResolver() {

            //URL解析为磁盘路径
            @Override
            public Resource resolveResource(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
                System.out.println("~~" + getClass().getSimpleName() + ".resolveResource~~");

                System.out.println("request is " + request);
                System.out.println("requestPath is " + requestPath);
                System.out.println("locations is " + locations);
                System.out.println("chain is " + chain);

                Resource resolved = chain.resolveResource(request, requestPath, locations);
                if (resolved != null) {
                    return resolved;
                }


//                try {
//                    //locations.get(0)是/cc/static/,requestPath是aa/bb/x.png，这样就能定位到磁盘文件
//                    Resource r = locations.get(0).createRelative(requestPath);//获取资源对象
//                    System.out.println(r);
//                    return r;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                return null;
            }

            //磁盘路径反解URL
            @Override
            public String resolveUrlPath(String resourcePath, List<? extends Resource> locations, ResourceResolverChain chain) {
                System.out.println("~~" + getClass().getSimpleName() + ".resolveUrlPath~~");

                System.out.println("resourcePath is " + resourcePath);
                System.out.println("locations is " + locations);
                System.out.println("chain is " + chain);

                String url = chain.resolveUrlPath(resourcePath, locations);
                if (url != null) {
                    return url;
                }

                return null;
            }
        };
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("/cc/")
//                .resourceChain(true)
//                .addResolver(resourceResolver);


        //方式二：使用系统自带对象
        String version = this.version;
        VersionResourceResolver versionResolver = new VersionResourceResolver()
                .addFixedVersionStrategy(version, "/aa/bb/**")
                .addVersionStrategy(new ContentVersionStrategy(), "/**");

        registry.setOrder(-1)
                .addResourceHandler("/resources/**")
                .addResourceLocations("/cc/static/")
                .resourceChain(false)
                .addResolver(versionResolver)
                .addResolver(resourceResolver);
    }
}
