package controller;

import dao.Car;
import dao.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import java.io.IOException;

/**
 * Created by Administrator on 2019/9/25 22:00.
 */
@Controller
public class AdviceController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
    }


    @GetMapping("/advice")
    public void ad(Teacher teacher, WebDataBinder dataBinder) {
        System.out.println("~~" + getClass().getSimpleName() + ".ad~~");

//        Teacher teacher = new Teacher();
//        DataBinder dataBinder = new DataBinder(teacher);

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
