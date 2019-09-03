package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletResponse;

/**
 * Created by Administrator on 2019/9/3 21:16.
 */
@Controller
//@RequestMapping("/person")
public class PathController {

    /**
     * 路径拼接
     * 如果类和方法都有Path属性，他们将被拼接
     */
//    @GetMapping("/person/{id}")
//    public String path(Model model, @PathVariable(required = false) Long id) {
//        System.out.println("~~" + getClass().getSimpleName() + ".path~~");
//        System.out.println(id);
//
//        model.addAttribute("message", "handleGet");
//        return "one";
//    }


//    @GetMapping("/person/{id}")
//    public void path(ServletResponse servletResponse) {
//        System.out.println("~~" + getClass().getSimpleName() + ".path~~");
//    }

}
