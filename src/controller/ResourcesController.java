package controller;

import dao.Book;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/10/8 15:13.
 */
@Controller
public class ResourcesController {


    @RequestMapping("/resource")
    public void resource(HttpServletResponse response) {
        System.out.println("~~" + getClass().getSimpleName() + ".resource~~");


    }



}
