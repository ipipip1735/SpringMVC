package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Administrator on 2019/9/18 10:29.
 */


@Configuration
public class ValidateConfig implements WebMvcConfigurer {

    @Override
    public Validator getValidator() {
        System.out.println("~~" + getClass().getSimpleName() + ".getValidator~~");

        Validator validator = new Validator() {

            @Override
            public boolean supports(Class<?> clazz) {
                System.out.println("~~[G]" + getClass().getSimpleName() + ".supports~~");
                System.out.println("clazz is " + clazz);
                return true;
            }

            @Override
            public void validate(Object target, Errors errors) {
                System.out.println("~~[G]" + getClass().getSimpleName() + ".validate~~");
                System.out.println("target is " + target);
                System.out.println("errors is " + errors);

                //方式一：使用工具类设置错误
//                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "Field is required.");

                //方式二：直接设置错误
//                errors.rejectValue("name", "xxx");

            }
        };

        return validator;
    }
}