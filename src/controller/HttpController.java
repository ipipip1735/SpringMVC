package controller;

import dao.Employee;
import dao.Person;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.Formatter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2019/9/30 8:46.
 */
@Controller
public class HttpController {

    @GetMapping("/http")
    public String http() {
        System.out.println("~~" + getClass().getSimpleName() + ".http~~");

        return "ajax";
    }


    /**
     * 处理AJAX发送的JSON对象
     */
//    @PostMapping(name = "/handler", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Person ajax(@RequestBody Person person) {
//        System.out.println("~~" + getClass().getSimpleName() + ".ajax~~");
//        System.out.println(person);
//
//        return person;
//    }


    /**
     * 处理AJAX发送的JSON对象
     */
    @PostMapping(name = "/handler")
    public void ajax(HttpEntity entity) {
        System.out.println("~~" + getClass().getSimpleName() + ".ajax~~");
        if (entity.hasBody()) {
            System.out.println(entity.getBody());
        }

        System.out.println(entity.getHeaders());
        HttpHeaders httpHeaders = entity.getHeaders();

        for (Map.Entry<String, List<String>> map : httpHeaders.entrySet())
            System.out.println(map);

        System.out.println(entity);
    }

}
