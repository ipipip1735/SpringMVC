package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.*;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/10/8 23:10.
 */
public class ResourcesConfig implements WebMvcConfigurer {


    //配置静态资源
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println("~~" + getClass().getSimpleName() + ".addResourceHandlers~~");
//
//        registry.addResourceHandler("/res/**")
//                .addResourceLocations("/cc/")
//                .setCachePeriod(365 * 24 * 3600);
//    }

    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }


    //配置静态资源，增加资源链
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("~~" + getClass().getSimpleName() + ".addResourceHandlers~~");


        //方式一：自定义解析器
//        ResourceResolver resourceResolver = new ResourceResolver() {
//
//            @Override
//            public Resource resolveResource(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
//                System.out.println("~~" + getClass().getSimpleName() + ".resolveResource~~");
//
//                System.out.println("request is " + request);
//                System.out.println("requestPath is " + requestPath);
//                System.out.println("locations is " + locations);
//                System.out.println("chain is " + chain);
//
//                Resource resolved = chain.resolveResource(request, requestPath, locations);
//                if (resolved != null) {
//                    return resolved;
//                }
//
//                String version = "static/v1.2.0/j.js";
//                try {
//                    Resource r = locations.get(0).createRelative(version);
//                    System.out.println(r);
//                    return r;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//            @Override
//            public String resolveUrlPath(String resourcePath, List<? extends Resource> locations, ResourceResolverChain chain) {
//                System.out.println("~~" + getClass().getSimpleName() + ".resolveUrlPath~~");
//
//                System.out.println("resourcePath is " + resourcePath);
//                System.out.println("locations is " + locations);
//                System.out.println("chain is " + chain);
//
//                return null;
//            }
//        };
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("/cc/")
//                .resourceChain(true)
//                .addResolver(resourceResolver);


        //方式二：使用系统自带对象
        VersionResourceResolver versionResolver = new VersionResourceResolver()
                .addFixedVersionStrategy("v1.2.0", "/**");

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/cc/static/")
                .resourceChain(false)
                .addResolver(versionResolver);

//        String version = "v1.2.0";
//        VersionResourceResolver versionResolver = new VersionResourceResolver()
//                .addFixedVersionStrategy(version, "/**/*.js")
//                .addFixedVersionStrategy(version, "/**/*.js")
//                .addContentVersionStrategy(version, "/**/*.css", "/**/*.png");


    }
}
