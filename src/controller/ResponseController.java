package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/9/4 11:40.
 */
@Controller
public class ResponseController {

    /**
     * 获取请求头信息
     * 使用@RequestHeader获取请求头信息
     */
    @GetMapping("/response")
    @ResponseBody
    public String response() {
        System.out.println("~~" + getClass().getSimpleName() + ".response~~");
        return "ok";
    }

}
