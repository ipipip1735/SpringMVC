package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@ComponentScan(basePackages = {"service"})
//@Import(PropertyEditorConfig.class)//属性编辑器配置
//@Import(FormattingConversionConfig.class)//格式化和类型转换配置
//@Import(ValidateConfig.class)//验证器
//@Import(MessageConverterConfig.class)//配置信息转换器
@Import(CORSConfig.class)//配置跨域
public class AppConfig {}
