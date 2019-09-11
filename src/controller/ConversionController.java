package controller;

import dao.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2019/9/8 17:08.
 */
@Controller
public class ConversionController {
    /**
     * 类型转换
     * 转换路径变量（字符串转为Person对象）
     */
    @GetMapping("/convert/{p}")
    public String pathConvert(@PathVariable Person p) {
        System.out.println("~~" + getClass().getSimpleName() + ".pathConvert~~");
        System.out.println(p);

        return "convert";
    }


    /**
     * 类型转换
     * 转换查询变量（字符串转为Person对象）
     */
    @GetMapping("/convert")
    public String queryConvert(@RequestParam Person p) {
        System.out.println("~~" + getClass().getSimpleName() + ".queryConvert~~");
        System.out.println(p);

        return "convert";
    }

}
