package controller;

import dao.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/9/29 17:07.
 */
@Controller
public class CorsController {

    @GetMapping("/cors")
    public String validate() {
        System.out.println("~~" + getClass().getSimpleName() + ".cors~~");

        return "cors";
    }


}
