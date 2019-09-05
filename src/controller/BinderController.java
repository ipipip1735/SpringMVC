package controller;

import dao.Person;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/9/5 13:12.
 */
@Controller
public class BinderController {

    /**
     * 注册转换器
     * 指定要转换的变量，可以是下面3种
     * 1.表单属性
     * 2.待绑定到Model容器的实例名，即被访问的控制器参数
     * 3.查询参数名
     */
//    @InitBinder("person")
//    @InitBinder("one")
//    public void initBinder(WebDataBinder binder) {
//        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
//        System.out.println(binder);
//
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        dateFormat.setLenient(false);
////        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }

    /**
     * 增加验证器
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
        binder.setValidator(new Validator() {
            @Override
            public boolean supports(Class<?> clazz) {
                System.out.println("~~" + getClass().getSimpleName() + ".supports~~");
                System.out.println(clazz);
                return false;
            }

            @Override
            public void validate(Object target, Errors errors) {
                System.out.println("~~" + getClass().getSimpleName() + ".validate~~");
                System.out.println("target is " + target);
                System.out.println("errors is " + errors);
            }
        });

    }


    @GetMapping("/bind")
    public void handle(@Validated String one) {
        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
        System.out.println(one);
    }


}
