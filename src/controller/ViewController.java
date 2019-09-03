package controller;

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

    @ModelAttribute
    public void populateModel(Model model) {

        //方式一：使用Map容器
        Map<String, String> map = new HashMap<>();
        map.put("one", "111");
        model.addAllAttributes(map);
//        model.addAttribute(accountRepository.findAccount(number));
    }



    /**
     * 路径参数可选，多路径时，参数可选
     */
    @GetMapping({"/model" })
    public void handleGetPath() {
        System.out.println("~~" + getClass().getSimpleName() + ".handleGetPath~~");
    }

}
