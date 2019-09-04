package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2019/9/3 21:16.
 */
@Controller
//@RequestMapping("/path")
public class PathController {

    /**
     * @GetMapping 是快捷方式，等价于 @RequestMapping(method=RequestMethod.GET)
     * 如果方法返回值为Void，这视图模板为URL路径对应的JSP文件，本例是path.jsp
     */
//    @GetMapping("/path")
//    public void path() {
//        System.out.println("~~" + getClass().getSimpleName() + ".path~~");
//    }


    /**
     * 如果类和方法都指定了path属性，那么将拼接
     * 本例中是/path/one
     */
//    @GetMapping("/one")
//    public String path(Model model) {
//        System.out.println("~~" + getClass().getSimpleName() + ".path~~");
//        return "path";
//    }


    /**
     * 如果方法参数为OutputStream或ServletResponse，且返回值为void，那么直接输出到客户端
     */
//    @GetMapping("/output")
//    public void path(OutputStream outputStream) {
//        System.out.println("~~" + getClass().getSimpleName() + ".path~~");
//        try {
//            outputStream.write("output ok".getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @GetMapping("/response")
//    public void path(ServletResponse servletResponse) {
//        System.out.println("~~" + getClass().getSimpleName() + ".path~~");
//        try {
//            servletResponse.getWriter().print("response ok");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
