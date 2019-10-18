package controller;

import dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

/**
 * Created by Administrator on 2019/10/18 13:54.
 */
@Controller
public class MessageSourceController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/message")
    public String error(Model model) {
        System.out.println("~~" + getClass().getSimpleName() + ".message~~");

        String msg = messageSource.getMessage("skt", new Object[]{"one"}, "ttt", Locale.CHINA);
        System.out.println("msg is " + msg);
        model.addAttribute("msg", msg);

        return "message";
    }

}
