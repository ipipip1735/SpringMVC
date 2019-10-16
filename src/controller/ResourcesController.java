package controller;

import dao.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/10/8 15:13.
 */
@Controller
public class ResourcesController {


    @Autowired
    private ResourceUrlProvider mvcResourceUrlProvider;

    @GetMapping("/resource")
    public String resource(Model model) {
        System.out.println("~~" + getClass().getSimpleName() + ".resource~~");
        String urlDM5 = mvcResourceUrlProvider.getForLookupPath("/resources/x.png");
        System.out.println("urlDM5 is " + urlDM5);
        model.addAttribute("urlDM5", urlDM5);

        String urlVersion = mvcResourceUrlProvider.getForLookupPath("/resources/aa/bb/x.png");
        System.out.println("urlVersion is " + urlVersion);
        model.addAttribute("urlVersion", urlVersion);

        return "resources";

    }


}
