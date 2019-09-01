package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.OneService;

import javax.servlet.ServletContext;

/**
 * Created by Administrator on 2019/9/1 9:44.
 */
@Controller
public class TwoController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/two", method = RequestMethod.GET)
    public String handle(Model model) {
        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");

        model.addAttribute("message", "Two Controller!");
        return "one";
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public void service() {
        System.out.println("~~" + getClass().getSimpleName() + ".service~~");


        String uploadPath = servletContext.getRealPath("");
        System.out.println("uploadPath is " + uploadPath);


        OneService oneBean = (OneService) applicationContext.getBean("oneSB");
        System.out.println(oneBean);




    }


}
