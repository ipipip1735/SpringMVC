package controller;

import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/10/4 16:10.
 */
@RestController
public class RestAPIController {

    @GetMapping("/restapi")
    public String restapi () {
        System.out.println("~~" + getClass().getSimpleName() + ".restapi~~");

        return "ok";
    }

    //使用URL变量
//    @RequestMapping("/restapi/{id}")
//    public String restapi (@PathVariable String id) {
//        System.out.println("~~" + getClass().getSimpleName() + ".restapi~~");
//        System.out.println("id is " + id);
//        return "ok";
//    }


    //使用实体对象
//    @GetMapping("/restapi")
//    public ResponseEntity<String> restapi(RequestEntity<String> request) {
//        System.out.println("~~" + getClass().getSimpleName() + ".restapi~~");
//
//        String head = request.getHeaders().getFirst("one");
//        System.out.println("head is " + head);
//
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("two", "2222");
//
//        ResponseEntity<String> responseEntity =  new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.OK);
//
//        return responseEntity;
//    }


}
