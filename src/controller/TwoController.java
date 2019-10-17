package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * Created by Administrator on 2019/8/30 9:09.
 */
@Controller
public class TwoController {


    @Autowired
    private ResourceUrlProvider mvcResourceUrlProvider;

    public TwoController() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @GetMapping("/two")
    public String two() {
        System.out.println("~~" + getClass().getSimpleName() + ".two~~");

        return "two";
    }

}
