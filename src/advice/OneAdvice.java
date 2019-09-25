package advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.io.IOException;

/**
 * Created by Administrator on 2019/9/25 22:05.
 */
@ControllerAdvice
public class OneAdvice {

    @ExceptionHandler
    public ResponseEntity<String> errorHandle(IOException ex) {
        System.out.println("~~" + getClass().getSimpleName() + ".errorHandle~~");


        return null;
    }



    @InitBinder
    public void initBinder() {
        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
    }

}
