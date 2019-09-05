package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    @ExceptionHandler
    public ResponseEntity<String> handle(IOException ex) {
        System.out.println("~~" + getClass().getSimpleName() + ".exception~~");
        return null;
    }

    @GetMapping("/error")
    public void handle(ServletResponse response) {
        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");

        try (PrintWriter pw = response.getWriter()) {
            pw.print("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
