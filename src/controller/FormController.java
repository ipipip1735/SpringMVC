package controller;

import dao.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/9/30 11:07.
 */
@Controller
public class FormController {
    @GetMapping("/form")
    public void form(@ModelAttribute Employee employee) {
        System.out.println("~~" + getClass().getSimpleName() + ".form~~");
        System.out.println("employee is " + employee);
    }


    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute Employee employee, BindingResult result, ModelMap model) {
        System.out.println("~~" + getClass().getSimpleName() + ".submit~~");
        if (result.hasErrors()) {
            System.out.println("Error!");
            return "error";
        }

        System.out.println("employee is " + employee);
        System.out.println("employee is " + employee.getName());
        System.out.println("employee is " + employee.getId());


        model.addAttribute("name", employee.getName());
        model.addAttribute("id", employee.getId());
        return "form";
    }
}