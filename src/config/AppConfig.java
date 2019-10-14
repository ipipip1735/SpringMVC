package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2019/8/31 16:05.
 */
//@EnableWebMvc
//@Import(PropertyEditorConfig.class)//属性编辑器配置
//@Import(FormattingConversionConfig.class)//格式化和类型转换配置
//@Import(ValidateConfig.class)//验证器
//@Import(MessageConverterConfig.class)//配置信息转换器
//@Import(CORSConfig.class)//配置跨域
//@Import(ResourcesConfig.class)//配置静态资源
//@Import(DefaultServletConfig.class)//配置默认Servlet
//@Import(PathMatchConfig.class)//配置静态资源
@Configuration
@ComponentScan(basePackages = {"service"})
public class AppConfig {}
