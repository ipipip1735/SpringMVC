package controller;

import dao.Teacher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Created by Administrator on 2019/9/29 17:07.
 */
@Controller
//@CrossOrigin(value = "http://example.com/", maxAge = 3600)
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CorsController {
//    @CrossOrigin(value = "http://example.com/", maxAge = 3600)
    @GetMapping("/cors")
    public String cors() {
        System.out.println("~~" + getClass().getSimpleName() + ".cors~~");

        return "cors";
    }


//    @ResponseBody
//    @GetMapping("/corsHandler")
//    public String res() {
//        System.out.println("~~" + getClass().getSimpleName() + ".res~~");
//
//        return "ok";
//    }

    @CrossOrigin("http://localhost")
    @GetMapping("/{index}")
    public void res(@PathVariable Long index) {
        System.out.println("~~" + getClass().getSimpleName() + ".res~~");

//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("Access-Control-Allow-Origin", "*");
//
//        return ResponseEntity.ok()
//                .headers(responseHeaders)
//                .build();

//        return "ok";
    }



}
