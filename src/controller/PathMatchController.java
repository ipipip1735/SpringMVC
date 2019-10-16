package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2019/10/16 21:57.
 */
@Controller
public class PathMatchController {

    @GetMapping("/pathMatch")
    public String pathMatch() {
        System.out.println("~~" + getClass().getSimpleName() + ".pathMatch~~");


        return "pathMatch";
    }

}
