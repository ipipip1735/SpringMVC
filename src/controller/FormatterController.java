package controller;

import binder.StudentFormat;
import dao.Person;
import dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2019/9/8 16:54.
 */
@Controller
public class FormatterController {


    /**
     * 使用Spring自带的格式化工具
     * @DateTimeFormat 是Spring自带的格式化工具
     */
//    @GetMapping("/formatter/{date}")
////    public String formatter(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
//    public String formatter(@PathVariable @DateTimeFormat(pattern = "yyyyMM") Date date) { //201910
////    public String formatter(@PathVariable @DateTimeFormat(style = "SS") Date date) {  //2019-09-17 16:40
////    public String formatter(@PathVariable Date date) {
//        System.out.println("~~" + getClass().getSimpleName() + ".formatter~~");
//
//        return "formatter";
//    }


    /**
     * 使用自定义格式化工具
     * @StudentFormat 是自定义的格式化工具
     */
    @GetMapping("/formatter/{stu}")
    public String formatter(@ModelAttribute("stu") @StudentFormat(sno = 18, name = "jack") Student student) {
        System.out.println("~~" + getClass().getSimpleName() + ".formatter~~");

        return "formatter";
    }


    /**
     * 使用注解格式化字段
     */
//    @GetMapping("/formatter/{birthday}")
//    public String formatter(@ModelAttribute("stu") Student student) {
//        System.out.println("~~" + getClass().getSimpleName() + ".formatter~~");
//
//        return "formatter";
//    }


}
