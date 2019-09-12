package controller;

import binder.PersonPE;
import dao.Car;
import dao.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/9/8 16:54.
 */
@Controller
public class ValidateController {

    /**
     * 绑定属性编辑器
     * 方式二：直接注册属性编辑器
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");

        Validator validator = new Validator() {

            @Override
            public boolean supports(Class<?> clazz) {
                System.out.println("~~" + getClass().getSimpleName() + ".supports~~");
                return true;
            }

            @Override
            public void validate(Object target, Errors errors) {
                System.out.println("~~" + getClass().getSimpleName() + ".validate~~");

            }
        };

        webDataBinder.setValidator(validator);//设置验证器
    }

    /**
     * 格式化
     * 格式化查询变量（字符串转为Person对象）
     */
    @GetMapping("/validate/{p}")
    public String validate(@Validated @PathVariable int p) {
        System.out.println("~~" + getClass().getSimpleName() + ".validate~~");


        return "validate";
    }

}
