package controller;

import dao.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/9/5 8:57.
 */
@Controller
//@SessionAttributes("person")
public class SessionController {


    /**
     * 手动绑定Seesion变量
     */
//    @GetMapping({"/session"})
//    public String handle(HttpSession session) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        if (session.getAttribute("person") == null) {
//            System.out.println("seesion is null");
//            Person person = new Person();
//            person.setName("bob");
//            person.setAge(26);
//            session.setAttribute("person", person);
//
//        } else {
//            Person person = (Person) session.getAttribute("person");
//            System.out.println(person.getName());
//        }
//        return "session";
//    }

    /**
     * 同步绑定Seesion变量
     * @SessionAttributes 所指定的Model属性将被绑定到Session变量
     * 本例中person是待绑定为model属性，它将同步绑定为session变量
     */
//    @GetMapping({"/seesion/{name}/{age}"})
//    public String handle(Person person, HttpSession session) {
//        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");
//
//        if (session.getAttribute("person") == null) {
//            System.out.println("seesion is null");
//        } else {
//            System.out.println(session.getAttribute("person"));
//        }
//        return "model";
//    }


}
