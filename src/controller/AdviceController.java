package controller;

import dao.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Created by Administrator on 2019/9/25 22:00.
 */
@Controller
public class AdviceController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");

        System.out.println(webDataBinder);
    }

    @GetMapping("advice/{age}")
    public String validate(Teacher teacher) {
        System.out.println("~~" + getClass().getSimpleName() + ".validate~~");

        return "advice";
    }


//    @ExceptionHandler
//    public ResponseEntity<String> errorHandle(IOException ex) {
//        System.out.println("~~" + getClass().getSimpleName() + ".errorHandle~~");
//
//
//        return null;
//    }



}
