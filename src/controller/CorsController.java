package controller;

import dao.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

/**
 * Created by Administrator on 2019/9/29 17:07.
 */
@Controller
public class CorsController {

    @GetMapping("/cors")
    public String cors() {
        System.out.println("~~" + getClass().getSimpleName() + ".cors~~");

        return "cors";
    }


    @GetMapping("/res")
    public void res(HttpRequest httpRequest) {
        System.out.println("~~" + getClass().getSimpleName() + ".res~~");


    }



}
