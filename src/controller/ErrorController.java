package controller;

import dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
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
public class ErrorController {

    @Autowired
    private MessageSource messageSource;


//    @ExceptionHandler
//    public ResponseEntity<String> handle(IOException ex) {
//        System.out.println("~~" + getClass().getSimpleName() + ".exception~~");
//        return null;
//    }


    @GetMapping("/error/{age}")
    public String error(@Validated Person person, BindingResult bindingResult) {
        System.out.println("~~" + getClass().getSimpleName() + ".error~~");



        return "error";
    }

}
