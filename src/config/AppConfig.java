package config;

import filter.OneFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@EnableWebMvc
//@Import(PropertyEditorConfig.class)//属性编辑器配置
//@Import(FormattingConversionConfig.class)//格式化和类型转换配置
//@Import(ValidateConfig.class)//验证器
//@Import(MessageConverterConfig.class)//配置信息转换器
//@Import(CORSConfig.class)//配置跨域
//@Import(DefaultServletConfig.class)//配置默认Servlet
//@Import(ResourcesConfig.class)//配置静态资源
//@Import(PathMatchConfig.class)//配置路径匹配策略
//@Import(ViewControllerConfig.class)//配置视图导航
//@Import(WebSocketConfig.class)//配置WebSocket
//@Import(AsyncConfig.class)//配置WebSocket
//@ComponentScan(basePackages = {"service"})
//@ComponentScan(basePackages = {"filter"})
public class AppConfig {}