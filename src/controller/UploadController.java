package controller;

import dao.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Administrator on 2019/9/30 11:07.
 */
@Controller
public class UploadController {
//    @GetMapping("/upload")
//    public void upload() {
//        System.out.println("~~" + getClass().getSimpleName() + ".upload~~");
//    }

//    @PostMapping(path = "/handler", consumes = {"application/json;charset=UTF-8"})
//    public void submit(@RequestBody Employee employee) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handler~~");
//        System.out.println(employee);
//    }
}