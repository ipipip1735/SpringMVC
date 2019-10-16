package config;

import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2019/10/14 21:45.
 */
public class PathMatchConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        System.out.println("~~" + getClass().getSimpleName() + ".configurePathMatch~~");

//        configurer.setUseSuffixPatternMatch(false);//不要匹配后缀
//        configurer.setUseTrailingSlashMatch(false);//不要匹配以/结尾
//        configurer.setUseRegisteredSuffixPatternMatch(true);

    }
}
