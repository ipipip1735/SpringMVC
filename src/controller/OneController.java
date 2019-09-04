package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/8/30 9:09.
 */
@Controller
public class OneController {

    public OneController() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @RequestMapping(path = "/one", method = RequestMethod.GET)
    public String one() {
        return "one";
    }

}
