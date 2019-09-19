package controller;

import binder.PersonPE;
import dao.Car;
import dao.Person;
import dao.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2019/9/8 16:54.
 */
@Controller
public class ValidateController {

    /**
     * 绑定验证器
     */
//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder) {
//        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
//
//        Validator validator = new Validator() {
//
//            @Override
//            public boolean supports(Class<?> clazz) {
//                System.out.println("~~" + getClass().getSimpleName() + ".supports~~");
//                System.out.println("clazz is " + clazz);
//                return true;
//            }
//
//            @Override
//            public void validate(Object target, Errors errors) {
//                System.out.println("~~" + getClass().getSimpleName() + ".validate~~");
//                System.out.println("target is " + target);
//                System.out.println("errors is " + errors);
//
//                //方式一：使用工具类设置错误
////                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "Field is required.");
//
//                //方式二：直接设置错误
////                errors.rejectValue("name", "xxx");
//
//            }
//        };
//
//        webDataBinder.setValidator(validator);//设置验证器
//    }


    //验证控制器验证
//    @GetMapping("/validate/{name}")
//    public String validate(@Validated Person person, BindingResult result) {
//        System.out.println("~~" + getClass().getSimpleName() + ".validate~~");
//
//        if(result.hasErrors()) System.out.println("error!");
//
//        return "validate";
//    }

    //验证实体参数
//    @GetMapping("/validate/{name}")
//    public String validate(Person person, BindingResult result) {
//        System.out.println("~~" + getClass().getSimpleName() + ".validate~~");
//
//        if(result.hasErrors()) System.out.println("error!");
//
//        return "validate";
//    }

    @GetMapping("/validate/{age}")
    public String validate(Teacher teacher) {
        System.out.println("~~" + getClass().getSimpleName() + ".validate~~");



        return "validate";
    }






    /**
     * 直接验证
     */
//    @GetMapping("/validate")
//    public String validate(@ModelAttribute("pp") Person pp, BindingResult result) {
//        System.out.println("~~" + getClass().getSimpleName() + ".validate~~");
//
//        pp.setName("bob");
//        result.reject("xxx");//设置错误码
//
//        return "validate";
//    }





    /**
     * 绑定验证
     * BindingResult对象用于查询绑定是否出现错误
     */
//    @GetMapping({"/model/{name}/{age}"})
//    public String handle(@ModelAttribute Person person, BindingResult result) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        if (result.hasErrors()) {
//            return "error";
//        } else {
//            return "model";
//        }
//    }

}
