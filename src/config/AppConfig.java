package config;

import binder.OnePropertyEditorRegistrar;
import binder.PersonConverter;
import controller.OneController;
import controller.TwoController;
import dao.Person;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Administrator on 2019/8/31 16:05.
 */
@Configuration
@ComponentScan(basePackages = {"service"})
//@Import(PropertyEditorConfig.class)
@Import(ConvertConfig.class)
public class AppConfig {}
