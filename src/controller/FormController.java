package controller;

import dao.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.BindStatus;

import java.lang.management.MemoryType;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

/**
 * Created by Administrator on 2019/9/30 11:07.
 */
@Controller
public class FormController {

    @GetMapping("/form")
    public void form(Employee employee, Model model, Errors errors) {
        System.out.println("~~" + getClass().getSimpleName() + ".form~~");
        System.out.println("employee is " + employee);


//        String[] interestList = {"fishing", "football"};
//        model.addAttribute("interestList", interestList);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "Field is required.");

        employee.setName("ok");
        model.addAttribute(employee);

//        String[] interestList = {"fishing", "football"};
//        model.addAttribute("interestList", interestList);


    }

    //方式一：使用Model
    //表单提交的数据将绑定到参数对象，如果不成功就把错误信息打印到表单页
//    @PostMapping("/addEmployee")
//    public String submit(@ModelAttribute Employee employee, BindingResult result, ModelMap model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".submit~~");
//        if (result.hasErrors()) {
//            System.out.println("Error!");
//            return "error";
//        }
//
//        System.out.println("employee is " + employee);
//        System.out.println("employee is " + employee.getName());
//        System.out.println("employee is " + employee.getId());
//
//
//        model.addAttribute("name", employee.getName());
//        model.addAttribute("id", employee.getId());
//        model.addAttribute("sex", employee.isSex());
//
//
//
//        return "form";
//    }


    //方式二：
    @PostMapping("/addEmployee")
    public String submit(@Validated Employee employee, BindingResult result, ModelMap model) {
        System.out.println("~~" + getClass().getSimpleName() + ".submit~~");
        if (result.hasErrors()) {
            System.out.println("Error!");
            ValidationUtils.rejectIfEmptyOrWhitespace(result, result.getFieldError().getField(), "required", "Field is required.");
            return "form";
        }

        System.out.println("employee is " + employee);
        System.out.println("employee is " + employee.getName());
        System.out.println("employee is " + employee.getId());


        model.addAttribute("name", employee.getName());
        model.addAttribute("id", employee.getId());
        model.addAttribute("sex", employee.isSex());




        return "form";
    }

}