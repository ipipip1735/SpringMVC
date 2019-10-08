package controller;

import dao.Teacher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Created by Administrator on 2019/9/29 17:07.
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CorsController {

    @RequestMapping("/cors")
    @CrossOrigin(allowCredentials = "true")
//@CrossOrigin(maxAge = 3600)
//    public void cors(HttpServletResponse response) {
//    public void cors(@CookieValue("one") String one) {
    public void cors() {
        System.out.println("~~" + getClass().getSimpleName() + ".cors~~");


    }

    @RequestMapping("/cookie")
    public void cookie(HttpServletResponse response) {
        System.out.println("~~" + getClass().getSimpleName() + ".cookie~~");

        Cookie cookie = new Cookie("one", "111");
        response.addCookie(cookie);


    }

}
