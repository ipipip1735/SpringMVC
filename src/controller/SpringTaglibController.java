package controller;

import dao.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Administrator on 2019/10/20 14:10.
 */
@Controller
public class SpringTaglibController {

    @GetMapping("/taglib/{name}")
    public String taglib(@Validated Employee employee, BindingResult bindingResult) {
        System.out.println("~~" + getClass().getSimpleName() + ".taglib~~");

        return "taglib";
    }
}