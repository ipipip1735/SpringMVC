package controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;
import static org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode.*;

/**
 * Created by Administrator on 2019/9/26 11:43.
 */
@Controller
//@RequestMapping(path = "/one/{one}")
public class UriController {





    /**
     * 使用URI模板
     */
    @GetMapping("/uri")
    public void uri(Model model) {

        String url = "https://www.example.org/{pp}/{qq}";


        //获取占位符变量名
        List<String> list = new UriTemplate(url).getVariableNames();
        for (String s : list) System.out.println(s);


        //抓取占位符变量名和对应的值
        UriTemplate template = new UriTemplate("https://example.com/hotels/{hotel}/bookings/{booking}");
        System.out.println(template.match("https://example.com/hotels/1/bookings/42")); //结果为 {hotel=1, booking=42}


        //匹配
        boolean b = new UriTemplate(url).matches("https://www.example.org/111/222");
        System.out.println(b);


        //给占位符赋值
        URI uri = new UriTemplate(url).expand("aaa");



        model.addAttribute("uri", uri);
        System.out.println(uri);
    }



    /**
     * 使用构建器
     */
//    @GetMapping("/uri")
//    public void uri(Model model) {
//
//
//        //简单使用
//        UriComponents uriComponents = UriComponentsBuilder
//                .fromUriString("https://example.com/hotels/{hotel}")
//                .queryParam("q", "{xx}")
//                .encode()//编译，把模板中某些字符编译为UNCODE
//                .build();//创建实例，即创建模板
//        System.out.println(uriComponents); //模板为https://example.com/hotels/{hotel}?q={xx}
//        URI uri = uriComponents
//                .expand("Westin", "123")//给模板的占位符赋值
//                .toUri();
//
//
//        //简化使用(构建并扩展)
////        URI uri = UriComponentsBuilder
////                .fromUriString("https://example.com/hotels/{hotel}")
////                .queryParam("q", "{xx}")
////                .buildAndExpand("Westin", "123")
////                .toUri();
//
//
//        model.addAttribute("uri", uri);
//        System.out.println(uri);
//    }




    /**
     * 使用构建器工厂
     */
//    @GetMapping("/uri")
//    public void factory(Model model) {
//
//        //使用工厂
//        String baseUrl = "https://example.com";
//        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUrl);
//        uriBuilderFactory.setEncodingMode(URI_COMPONENT);
//        URI uri = uriBuilderFactory.uriString("/hotels/{hotel}")
//                .queryParam("q", "{q}")
//                .build("Wes;t:in", "12>3");
//
//        model.addAttribute("uri", uri);
//    }


    /**
     * URI编译机制
     */
//    @GetMapping("/uri")
//    public void uriEncoding(Model model) {
//
//        //使用 UriComponentsBuilder编码
//        URI uri = UriComponentsBuilder.fromUriString("https://example.com/ho:t;e&l s/{hotel}")
//                .queryParam("q", "{xx}")
//                .encode()
//                .build()
//                .expand("We:s;t&in", "12<3")
//                .toUri();
//
//
//
//        //使用 UriComponentsBuilder编码
//        //这里拆开来写，为了方便演示，所以没有使用链式写法
////        UriComponents uriComponents = UriComponentsBuilder.fromUriString("https://example.com/ho:t;e&l s/{hotel}")
////                .queryParam("q", "{xx}")
////                .build();
////        URI uri = uriComponents.expand("We:s;t&in", "12<3")
////                .encode()//先扩展，再编码
////                .toUri();
////
////        model.addAttribute("uri", uri);
//
//    }


    /**
     * servlet请求
     */
//    @GetMapping("/uri")
//    public void uriBuilder(HttpServletRequest request, Model model) {
//        //覆写查询参数
////        UriComponents uriComponents = ServletUriComponentsBuilder.fromRequest(request)
////                .replaceQueryParam("aaa", "{xxx}")
////                .build()
////                .expand("123")
////                .encode();
////        URI uri = uriComponents.toUri();
////        model.addAttribute("uri", uri);
////        System.out.println(uriComponents.toUri().toString());
//
//
//        //覆写路径
////        UriComponents uriComponents = ServletUriComponentsBuilder.fromContextPath(request)
////                .path("/accounts")
////                .build();
////        model.addAttribute("uri", uriComponents.toUri());
////        System.out.println(uriComponents.toUri().toString());
//
//
//        //覆写相对路径
////        UriComponents uriComponents = ServletUriComponentsBuilder.fromServletMapping(request)
////                .path("/accounts")
////                .build();
////        model.addAttribute("uri", uriComponents.toUri());
////        System.out.println(uriComponents.toUri().toString());
//
//    }


    /**
     * 通过控制器方法创建
     */
//    @GetMapping("/two/{two}")
//    public String uriBuilder(HttpServletRequest request, @PathVariable int two, Model model) {
//
//        //控制器路径（创建匹配控制器方法的URI）
//        UriComponents uriComponents = MvcUriComponentsBuilder
//                .fromMethodName(this.getClass(), "uriBuilder", null, 31, null)
//                .buildAndExpand(42);
//        URI uri = uriComponents.encode().toUri();
//        model.addAttribute("uri", uri.toString());
//        System.out.println(uri.toString());
//
//        return "uri";
//    }


    /**
     * 通过视图获取 URI
     */
//    @GetMapping("/two/{two}")
//    public String uriBuilder(@PathVariable Integer two) {
//
//        return "uri";
//    }


}
