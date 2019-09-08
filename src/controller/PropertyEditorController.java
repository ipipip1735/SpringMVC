package controller;

import binder.PersonPE;
import dao.Person;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ServerWebExchangeDecorator;

/**
 * Created by Administrator on 2019/9/5 13:12.
 */
@Controller
public class PropertyEditorController {

    //方式一：使用属性编辑登记员
//    private PropertyEditorRegistrar propertyEditorRegistrar;//注入登记员
//    public PropertyEditorController(PropertyEditorRegistrar propertyEditorRegistrar) {
//        this.propertyEditorRegistrar = propertyEditorRegistrar;//构造函数注入
//    }
//    @InitBinder
//    public void initBinder(ServletRequestDataBinder binder) {
//        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
//
//        propertyEditorRegistrar.registerCustomEditors(binder);//注册自定义属性编辑器
//    }



    //方式二：直接注册属性编辑器
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
//        System.out.println(propertyEditorRegistrar);
//        propertyEditorRegistrar.registerCustomEditors(binder);

        webDataBinder.registerCustomEditor(Person.class, new PersonPE());
    }



    @GetMapping("/pe/{person}")
    public String handle(@PathVariable Person person) {
        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
        System.out.println(person);
        return "pe";
    }
}
