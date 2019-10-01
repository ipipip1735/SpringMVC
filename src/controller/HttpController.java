package controller;

import dao.Employee;
import dao.Person;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.Formatter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Administrator on 2019/9/30 8:46.
 */
@Controller
public class HttpController {


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
//        webDataBinder.addCustomFormatter(new Formatter<Person>() {
//            @Override
//            public Person parse(String text, Locale locale) throws ParseException {
//                System.out.println(text);
//                return null;
//            }
//
//            @Override
//            public String print(Person object, Locale locale) {
//                return object.toString();
//            }
//        });


        webDataBinder.setConversionService(conversionService);



    }


    @GetMapping("/http")
    public String http() {
        System.out.println("~~" + getClass().getSimpleName() + ".http~~");

        return "ajax";
    }


    /**
     * 方式一：
     */
//    @PostMapping(name = "/handler", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public String ajax(@RequestBody String person) {
//        System.out.println("~~" + getClass().getSimpleName() + ".ajax~~");
//        System.out.println(person);
//
//        return "ok";
//    }


    /**
     * 方式二：
     */
    @PostMapping(name = "/handler", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String ajax(@RequestBody Person person) {
        System.out.println("~~" + getClass().getSimpleName() + ".ajax~~");
        System.out.println(person);

        return "ok";
    }



}
