package controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2019/9/3 21:16.
 */
@Controller
public class RetureController {

    /**
     * 使用@ResponseBody
     */
//    @GetMapping("/return")
//    @ResponseBody
//    public String responseBody() {
//        System.out.println("~~" + getClass().getSimpleName() + ".responseBody~~");
//        return "ok";
//    }



    /**
     * void方法
     */
//    @GetMapping("/return")
//    public void outputStream(OutputStream out) {
//        System.out.println("~~" + getClass().getSimpleName() + ".outputStream~~");
//        try {
//            out.write("ok".getBytes());
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @GetMapping("/return")
//    public void returnVoid(ServletResponse servletResponse) {
//        System.out.println("~~" + getClass().getSimpleName() + ".returnVoid~~");
//        try {
//            servletResponse.getWriter().print("ok");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @GetMapping("/return")
//    @ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "xxxx")
//    public void responseBody() {
//        System.out.println("~~" + getClass().getSimpleName() + ".responseBody~~");
//    }
    @GetMapping("/return")
    public void responseBody() {
        System.out.println("~~" + getClass().getSimpleName() + ".responseBody~~");
    }

}
