package controller;

import dao.Book;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/10/8 15:13.
 */
@Controller
public class CacheController {

    public CacheController() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @GetMapping("cache")
    public ResponseEntity<Book> cache() {
        System.out.println("~~" + getClass().getSimpleName() + ".cache~~");

        Book book = new Book();
        book.setOwner("bob");
        book.setPrice(12);
        System.out.println(book.toString());

        String ETag = Base64.getEncoder().encodeToString(book.toString().getBytes());
        System.out.println("etag is " + ETag);


        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.maxAge(30, TimeUnit.SECONDS))
                .eTag(ETag)
                .body(book);
    }



    @GetMapping("/cacheMatch")
    public String myHandleMethod(WebRequest webRequest) {
        System.out.println("~~" + getClass().getSimpleName() + ".myHandleMethod~~");

        Book book = new Book();
        book.setOwner("bob");
        book.setPrice(12);
        System.out.println(book.toString());

        String ETag = Base64.getEncoder().encodeToString(book.toString().getBytes());
        System.out.println("etag is " + ETag);


        if (webRequest.checkNotModified(ETag)) {
            System.out.println("nnnnnnnnnnnnn");
            return null;
        }

        return "cache";
    }

}
