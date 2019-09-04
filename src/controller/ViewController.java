package controller;

import dao.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

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
//        model.addAttribute("one", "111");
//
//        //方式二：增加对象
//        Person person = new Person();
//        person.setAge(123);
//        person.setName("bob");
//        model.addAttribute(person);
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
//    @ModelAttribute
//    public int handle(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//


    /**
     * 返回值将增加到Model容器
     */
    @GetMapping({"/model"})
    public void handle(Person person) {
        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
        person.setName("bob");
    }


    /**
     * 使用Model作为参数
     */
//    @GetMapping({"/model" })
//    public void handle(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//        model.addAttribute("one", "111");
//    }


    /**
     * 使用@RequestMapping修饰方法参数
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


}
