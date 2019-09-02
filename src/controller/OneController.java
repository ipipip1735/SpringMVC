package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2019/8/30 9:09.
 */
@Controller
@RequestMapping("/one")
public class OneController {

    public OneController() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String handle(Model model) {
        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");

        model.addAttribute("message", "Spring MVC Framework!");
        return "one";
    }

}
