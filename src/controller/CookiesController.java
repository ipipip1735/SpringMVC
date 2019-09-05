package controller;

import dao.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Administrator on 2019/9/5 10:08.
 */
@Controller
public class CookiesController {


    /**
     * 手动绑定Cookie变量
     */
//    @GetMapping("/cookies")
//    public void handle(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        //判断是否有Cookie
//        boolean b = Arrays.stream(request.getCookies())
//                .anyMatch(cookie -> {
//                    if (cookie.getName() == "person") {
//                        System.out.println(cookie.getName());
//                        return true;
//                    } else {
//                        System.out.println("cookie is " + cookie.getName());
//                        return false;
//                    }
//                });
//
//        //如果没有增加就增加
//        if (!b) {
//
//            Cookie cookie = new Cookie("person", "jack");
//            cookie.setMaxAge(20);
//            response.addCookie(cookie);
//            System.out.println("add cookie name");
//        }
//    }


    /**
     * 手动绑定Cookie变量，使用Spring工具类
     */
//    @GetMapping("/cookies")
//    public void handle(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        Cookie c = WebUtils.getCookie(request, "person");
//        System.out.println("c is " + c);
//
//        if (c != null) {
//            System.out.println(c.getValue());
//        } else {
//            Cookie cookie = new Cookie("person", "jack");
//            cookie.setMaxAge(20);
//            response.addCookie(cookie);
//            System.out.println("add cookie person");
//        }
//    }


    /**
     * 使用@CookieValue获取Cookie
     * 一般会增加required属性，因为如果Cookie没有设置就会报错
     */
    @GetMapping("/cookies")
    public void cookies(@CookieValue(name = "two", required = false) String cookie, HttpServletResponse response) {
        System.out.println("~~" + getClass().getSimpleName() + ".cookies~~");

        if (cookie == null) {
            response.addCookie(new Cookie("two", "222"));
            System.out.println("set cookies");
        }

        try {
            response.getWriter().print(cookie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
