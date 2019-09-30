package controller;

import dao.Employee;
import dao.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Administrator on 2019/9/30 8:46.
 */
@Controller
public class HttpController {

    @GetMapping("/http")
    public String http() {
        System.out.println("~~" + getClass().getSimpleName() + ".http~~");

        return "ajax";
    }



    @PostMapping("/hanler")
    @ResponseBody
    public String webRequest(@RequestBody String person) {
        System.out.println("~~" + getClass().getSimpleName() + ".webRequest~~");
        System.out.println(person);

        return "ok";
    }



}
