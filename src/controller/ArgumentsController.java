package controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2019/9/3 21:16.
 */
@Controller
@RequestMapping("/arguments")
public class ArgumentsController {

    /**
     * 路径参数
     * URL中的{xx}将作为@PathVariable修饰参数的值
     * 例如，URL为/arguments/bob，那么参数name=bob
     */
//    @GetMapping("/{name}")
//    public void pathArgs(@PathVariable String name, ServletResponse response) {
//        System.out.println("~~" + getClass().getSimpleName() + ".pathArgs~~");
//        try {
//            response.getWriter().print(name);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 查询参数
     * URL中的查询参数（?后的部分）将作为@RequestParam修饰参数的值
     * 例如，URL为/arguments?one=111，那么参数one=111
     */
//    @GetMapping
//    public void queryArgs(@RequestParam String one, ServletResponse response) {
//        System.out.println("~~" + getClass().getSimpleName() + ".queryArgs~~");
//        try {
//            response.getWriter().print(one);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * 矩阵参数（有点问题以后再说）
     * 矩阵参数使用分号分隔，例如/arguments;one=11;two=22，矩阵变量one=11，two=22
     */
//    @GetMapping
//    public void matrixArgs(@MatrixVariable int one, @MatrixVariable int two, ServletResponse response) {
//        System.out.println("~~" + getClass().getSimpleName() + ".matrixArgs~~");
//
//        System.out.println("one is " + one);
//        System.out.println("two is " + two);
//
//    }

}
