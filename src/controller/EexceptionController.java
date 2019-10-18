package controller;

import dao.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2019/9/5 13:23.
 */
@Controller
public class EexceptionController {

//    @ExceptionHandler
//    public ResponseEntity<String> handle(IOException ex) {
//        System.out.println("~~" + getClass().getSimpleName() + ".exception~~");
//        return null;
//    }


    @GetMapping("/error/{age}")
    public String error(@Validated Person person, BindingResult bindingResult) {
        System.out.println("~~" + getClass().getSimpleName() + ".error~~");

        if (bindingResult.hasErrors()) {
            System.out.println("error!!");
            ValidationUtils.rejectIfEmpty(bindingResult, "name", "xx", "ttt");

        }


        for (ObjectError error : bindingResult.getAllErrors()) {
            System.out.println(error);
        }


        return "error";
    }

}
