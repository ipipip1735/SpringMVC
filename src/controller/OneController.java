package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2019/8/30 9:09.
 */
@Controller
public class OneController {

    public OneController() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @GetMapping(path = "/one")
    public String one() {
        System.out.println("~~" + getClass().getSimpleName() + ".one~~");

        return "one";
    }

}
