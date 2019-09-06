package controller;

import dao.Person;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Created by Administrator on 2019/9/5 13:12.
 */
@Controller
public class PropertyEditorController {

//    private final PropertyEditorRegistrar customPropertyEditorRegistrar;

//    public BinderController(PropertyEditorRegistrar propertyEditorRegistrar) {
//        this.customPropertyEditorRegistrar = propertyEditorRegistrar;
//    }


    /**
     * 注册转换器
     * 指定要转换的变量，可以是下面3种
     * 1.表单属性
     * 2.待绑定到Model容器的实例名，即被访问的控制器参数
     * 3.查询参数名
     */
//    @InitBinder("person")
//    @InitBinder("one")
//    public void initBinder(WebDataBinder binder) {
//        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
//        System.out.println(binder);
//
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        dateFormat.setLenient(false);
////        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }


    /**
     * 增加验证器
     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
//
//        //注册验证器
////        binder.setValidator(new Validator() {
////            @Override
////            public boolean supports(Class<?> clazz) {
////                System.out.println("~~" + getClass().getSimpleName() + ".supports~~");
////                System.out.println(clazz);
////                return false;
////            }
////
////            @Override
////            public void validate(Object target, Errors errors) {
////                System.out.println("~~" + getClass().getSimpleName() + ".validate~~");
////                System.out.println("target is " + target);
////                System.out.println("errors is " + errors);
////            }
////        });
//
//
//        //注册属性修改器
//
//
//    }


    /**
     * 绑定属性修改器
     */
//    @InitBinder
//    public void initBinder(ServletRequestDataBinder binder) {
//        System.out.println("~~" + getClass().getSimpleName() + ".initBinder~~");
//
//        customPropertyEditorRegistrar.registerCustomEditors(binder);
//    }



    @GetMapping("/pe")
    public void handle(Person p) {
        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
        System.out.println(p);
    }


}
