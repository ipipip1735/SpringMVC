package controller;

import dao.Car;
import dao.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/9/4 5:28.
 */
@Controller

public class ViewController {

    /**
     * 给Model对象增加属性
     * @ModelAttribute 方法将先于 @ModelAttribute 方法调用
     */
//    @ModelAttribute
//    public void addData(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".addData~~");
//
//        //方式一：增加属性
////        model.addAttribute("one", "111");
//
//        //方式二：增加对象
////        Person person = new Person();
////        person.setAge(123);
////        person.setName("bob");
////        model.addAttribute(person);
//
//
//        //方式三：增加Map容器
////        Map<String, String> map = new HashMap<>();
////        map.put("one", "222");
////        model.addAllAttributes(map);
//    }

    /**
     * 返回值将增加到Model容器
     */
//    @GetMapping({"/model"})
//    public void handle() {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//    }


    /**
     * 通过URL路径参数实例化Model属性
     * 将调用路径参数匹配的setter/getter初始化
     */
//    @GetMapping({"/model"})
//    public String handle(Car car) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//        return "model";
//    }


    /**
     * 通过URL查询参数实例化Model属性
     */
//    @GetMapping({"/model"})
//    public String handle(Person person) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//        return "model";
//    }


    /**
     * 使用Model作为参数
     */
//    @GetMapping({"/model" })
//    public void handle(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//        model.addAttribute("one", "111");
//    }


    /**
     * 使用@ModelAttribute修饰方法参数
     */
//    @GetMapping({"/model/{one}" })
//    public String handle(@ModelAttribute String one) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//        return "model";
//    }


    /**
     * 使用@RequestMapping修饰方法
     */
//    @GetMapping({"/model/{one}" })
//    @ModelAttribute
//    public String handle(String one) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//        return "model";
//    }


    /**
     * 绑定验证
     * BindingResult对象用于查询绑定是否出现错误
     */
//    @GetMapping({"/model/{name}/{age}"})
//    public String handle(@ModelAttribute Person person, BindingResult result) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        if (result.hasErrors()) {
//            return "error";
//        } else {
//            return "model";
//        }
//    }


}
