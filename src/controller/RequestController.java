package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/9/4 10:44.
 */
@Controller
public class RequestController {

    /**
     * 获取请求头信息
     * 使用@RequestHeader获取请求头信息
     */
    @GetMapping("/request")
    public void request(@RequestHeader("Accept-Encoding") String encoding, ServletResponse response) {
        System.out.println("~~" + getClass().getSimpleName() + ".request~~");

        try {
            response.getWriter().print(encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



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
