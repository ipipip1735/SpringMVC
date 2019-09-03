package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/8/30 9:09.
 */
@Controller
@RequestMapping("/one")
public class OneController {

    public OneController() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    /**
     * 路径拼接，类级注解和方法注解拼接匹配，/one/person/123
     */
//    @GetMapping("/person/{id}")
//    public String handleGet(Model model, @PathVariable(required = false) Long id) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handleGet~~");
//        System.out.println(id);
//
//        model.addAttribute("message", "handleGet");
//        return "one";
//    }

    /**
     * 路径参数可选，多路径时，参数可选
     */
//    @GetMapping({"/person/{id}", "/person" })
//    public String handleGetPath(Model model, @PathVariable(required = false) Long id) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handleGetPath~~");
//        System.out.println(id);
//
//        model.addAttribute("message", "handleGet");
//        return "one";
//    }


    /**
     * 解析视图
     * @param model
     * @return
     */
//    @GetMapping("/person")
//    public String handleGet(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handleGet~~");
//
//        model.addAttribute("message", "handleGet");
//        return "one";
//    }

    /**
     * 限定请求方法
     */
//    @RequestMapping(method = RequestMethod.GET)
//    public String handleDefulat(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handleDefulat~~");
//
//        model.addAttribute("message", "Spring MVC Framework!");
//        return "one";
//    }


    /**
     * 限定请求方法
     */
//    @RequestMapping(name = "/rb", method = RequestMethod.GET)
//    @ResponseBody
//    public String responseBody(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".responseBody~~");
//        return "xoasdjf;sadjf ";
//    }


    /**
     * 获取请求参数
     */
//    @GetMapping
//    public String requestMapping(Model model, @RequestParam("id") long id) {
//        System.out.println("~~" + getClass().getSimpleName() + ".requestMapping~~");
//        System.out.println(id);
//
//        model.addAttribute("message", "Spring MVC Framework!");
//        return "one";
//    }






    /**
     * Post请求
     */
//    @PostMapping
//    public String handlePost(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handlePost~~");
//
//        model.addAttribute("message", "Spring MVC Framework!");
//        return "one";
//    }

}
