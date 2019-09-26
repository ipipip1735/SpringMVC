package advice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.AbstractController;

import java.io.IOException;

/**
 * Created by Administrator on 2019/9/25 22:05.
 */
@ControllerAdvice
//@ControllerAdvice("controller") //包限制
//@ControllerAdvice(annotations = Controller.class) //注解限制
//@ControllerAdvice(assignableTypes = {AbstractController.class}) //类型限制
//@Component
public class OneAdvice {

    @ExceptionHandler
    public ResponseEntity<String> errorHandle(IOException ex) {
        System.out.println("~~" + getClass().getSimpleName() + ".errorHandle~~");


        return null;
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");

        System.out.println(webDataBinder);
    }

}
