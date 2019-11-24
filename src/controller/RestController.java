package controller;

import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.Arrays;

/**
 * Created by Administrator on 2019/10/4 16:10.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    //使用实体对象
//    @GetMapping("/rest")
//    public ResponseEntity<String> rest(RequestEntity<String> request) {
//        System.out.println("~~" + getClass().getSimpleName() + ".restapi~~");
//
//        String head = request.getHeaders().getFirst("one");
//        System.out.println("head is " + head);
//
//        HttpHeaders responseHeaders = new HttpHeaders(); //可选的，可以传递null
//        responseHeaders.set("two", "2222");
//
//        ResponseEntity<String> responseEntity =  new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.OK);
//
//        return responseEntity;
//    }


    //使用实体对象
//    @RequestMapping("/rest")
//    public HttpEntity<String> handleUserRequest (HttpEntity requestEntity) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handleUserRequest~~");
//
//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.put("Cache-Control", Arrays.asList("max-age=3600"));
//
//        HttpEntity<String> responseEntity = new HttpEntity<>("my response body", headers);
//        return responseEntity;
//    }


    //使用响应实体对象
    @RequestMapping("/rest")
    public HttpEntity<String> handleUserRequest (HttpEntity requestEntity) {
        System.out.println("~~" + getClass().getSimpleName() + ".handleUserRequest~~");


        //方式一
//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.add("xx", "yy");
//        headers.put("Cache-Control", Arrays.asList("max-age=3600"));
//        ResponseEntity<String> responseEntity = new ResponseEntity<>("GO", headers, HttpStatus.OK);



        //方式二
        ResponseEntity<String> responseEntity = ResponseEntity.created(URI.create("http://www.example.com/"))
                .header("xx", "yy")
                .contentType(MediaType.TEXT_PLAIN)
//                .body("ok");//body()和build()返回值是一样的
                .build();

        //方式三
//        ResponseEntity<String> responseEntity = ResponseEntity.ok("GO");

        //方式四
//        ResponseEntity<String> responseEntity = ResponseEntity.noContent().build();

        //方式五
//        ResponseEntity<String> responseEntity = ResponseEntity.notFound().build();


        return responseEntity;
    }

}
