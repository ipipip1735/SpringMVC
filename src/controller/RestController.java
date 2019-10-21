package controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/10/4 16:10.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {


//    @RequestMapping("/handleUserRequest")
//    public HttpEntity<String> handleUserRequest (HttpEntity requestEntity) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handleUserRequest~~");
//
//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.put("Cache-Control", Arrays.asList("max-age=3600"));
//
//        HttpEntity<String> responseEntity = new HttpEntity<>("my response body", headers);
//        return responseEntity;
//    }


    @GetMapping("/something")
    public HttpEntity<String> handleUserRequest() {
        System.out.println("~~" + getClass().getSimpleName() + ".handleUserRequest~~");

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("Cache-Control", Arrays.asList("max-age=3600"));

        HttpEntity<String> responseEntity = new HttpEntity<>("my response body", headers);
        return responseEntity;
    }


}
