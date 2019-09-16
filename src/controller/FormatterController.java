package controller;

import dao.Person;
import dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Administrator on 2019/9/8 16:54.
 */
@Controller
public class FormatterController {


    @GetMapping("/formatter/{date}")
//    public String formatter(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
    public String formatter(@PathVariable @DateTimeFormat(pattern = "yyyyMM") Date date) {
//    public String formatter(@PathVariable @DateTimeFormat(style = "S-") Date date) {
//    public String formatter(@PathVariable Date date) {
        System.out.println("~~" + getClass().getSimpleName() + ".formatter~~");

        System.out.println(date);

        return "formatter";
    }

//    @GetMapping("/formatter/{birthday}")
//    public String formatter(@ModelAttribute("stu") Student student) {
//        System.out.println("~~" + getClass().getSimpleName() + ".formatter~~");
//
//        return "formatter";
//    }






}
