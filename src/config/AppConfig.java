package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.annotation.Validated;

/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@ComponentScan(basePackages = {"service"})
//@Import(PropertyEditorConfig.class)//属性编辑器配置
@Import(FormattingConversionConfig.class)//格式化和类型转换配置
//@Import(ValidateConfig.class)//验证器
public class AppConfig {}
