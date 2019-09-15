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
public class ModelController {

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
     * 如果返回值为Bean，框架将隐式追加到Model容器
     */
//    @GetMapping({"/model"})
//    public Person handle() {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        Person person = new Person();
//        person.setName("Mack");
//        return person;
//    }


    /**
     * 通过URL路径参数实例化Model属性
     * 将调用路径参数匹配的setter/getter初始化
     */
//    @GetMapping({"/model/{owner}/{price}"})
//    public String handle(Car car) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        System.out.println("Owner is " + car.getOwner());
//        System.out.println("Price is " + car.getPrice());
//
//        return "model";
//    }


    /**
     * 通过URL查询参数实例化Model属性
     * /model?name=bob&age=12，框架将调用对应的Setter初始化person实例
     */
//    @GetMapping({"/model"})
//    public String handle(Person person) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        System.out.println("Name is " + person.getName());
//        System.out.println("Age is " + person.getAge());
//        return "model";
//    }


    /**
     * 使用Model作为参数
     * 方法体中使用model对象手动绑定到Model容器
     */
//    @GetMapping({"/model" })
//    public void handle(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//        model.addAttribute("one", "111");
//    }



    /**
     * 使用@ModelAttribute修饰方法参数
     * 框架将隐式增加@ModelAttribute参数到Model容器
     */
//    @GetMapping({"/model/{one}" })
//    public String handle(@ModelAttribute("one") String o) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        System.out.println(o);
//        return "model";
//    }




    /**
     * 使用@ModelAttribute修饰方法
     * @ModelAttribute 方法将先于其他方法被调用
     * 控制器参数实例化时首先检查Model容器中是否有匹配的实例，如果@ModelAttribute 方法中已经增加了，则直接使用此实例
     */
    @ModelAttribute
    public void addModel(Model model) {
        System.out.println("~~" + getClass().getSimpleName() + ".addModel~~");

        model.addAttribute("one", Integer.valueOf(342));

        Person person = new Person();
        System.out.println(person);
        person.setName("bob");
        model.addAttribute(person);

        Car car = new Car();
        System.out.println(car);
        car.setOwner("jack");
        car.setPrice(1231);
        model.addAttribute("c", car);
    }
    @GetMapping({"/model" })
        public void handle(Person p, @ModelAttribute("c") Car car) {
        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
        System.out.println(p.getName());
        System.out.println(p);

        System.out.println(car.getOwner());
        System.out.println(car.getPrice());
        System.out.println(car);
    }

}
