package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

import static org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode.*;

/**
 * Created by Administrator on 2019/9/26 11:43.
 */
@Controller
public class UriController {

    /**
     * 使用构建器
     */
//    @GetMapping("/uri")
//    public void uri(Model model) {
//
//
//        //简单使用
////        UriComponents uriComponents = UriComponentsBuilder
////                .fromUriString("https://example.com/hotels/{hotel}")
////                .queryParam("q", "{q}")
////                .encode()
////                .build();
////        URI uri = uriComponents.expand("Westin", "123").toUri();
//
//
//        //简化使用(构建并扩展)
//        URI uri = UriComponentsBuilder
//                .fromUriString("https://example.com/hotels/{hotel}")
//                .queryParam("q", "{q}")
//                .buildAndExpand("Westin", "123")
//                .toUri();
//
//
//        model.addAttribute("uri", uri);
//        System.out.println(uri);
//    }


//    @GetMapping("/uri")
//    public void webClinet(Model model) {
//
////        String baseUrl = "https://example.org";
////        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
////        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
////        WebClient


    //使用 REST URL
//    String baseUrl = "https://example.org";
//    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
//        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
//    RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setUriTemplateHandler(factory);
//    restTemplate.get

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
//
//        //使用模板
////        String baseUrl = "https://example.com";
////        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUrl);
////        uriBuilderFactory.setEncodingMode(URI_COMPONENT);
////
////        RestTemplate restTemplate = new RestTemplate();
////        restTemplate.setUriTemplateHandler(uriBuilderFactory);
////
//////        WebClient client = WebClient.builder().uriBuilderFactory(factory).build();
//
//
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
////        URI uri = UriComponentsBuilder.fromUriString("https://example.com/ho:t;e&l s/{hotel}")
////                .queryParam("q", "{q}")
////                .encode()
////                .build()
////                .expand("We:s;t&in", "12<3")
////                .toUri();
//
//
//
//        //使用 UriComponentsBuilder编码
//        //这里拆开来写，为了方便演示，所以没有使用链式写法
//        UriComponents uriComponents = UriComponentsBuilder.fromUriString("https://example.com/ho:t;e&l s/{hotel}")
//                .queryParam("q", "{q}")
//                .build();
//        URI uri = uriComponents.expand("We:s;t&in", "12<3")
//                .encode()//先扩展，再编码
//                .toUri();
//
//        model.addAttribute("uri", uri);
//
//    }


    /**
     * servlet请求
     */
    @GetMapping("/uri/{xx}")
    public String uriBuilder(HttpServletRequest request, PathVariable pathVariable, Model model) {

        //覆写查询参数
//        UriComponents uriComponents = ServletUriComponentsBuilder.fromRequest(request)
//                .replaceQueryParam("aaa", "{xxx}")
//                .build()
//                .expand("123")
//                .encode();
//        URI uri = uriComponents.toUri();
//        model.addAttribute("uri", uri);
//        System.out.println(uriComponents.toUri().toString());


        //覆写路径
//        UriComponents uriComponents = ServletUriComponentsBuilder.fromContextPath(request)
//                .path("/accounts")
//                .build();
//        model.addAttribute("uri", uriComponents.toUri());
//        System.out.println(uriComponents.toUri().toString());


        //覆写相对路径
//        UriComponents uriComponents = ServletUriComponentsBuilder.fromServletMapping(request)
//                .path("/accounts")
//                .build();
//        model.addAttribute("uri", uriComponents.toUri());
//        System.out.println(uriComponents.toUri().toString());


        //
        UriComponents uriComponents = MvcUriComponentsBuilder
                .fromMethodName(this.getClass(), "uriBuilder", 21)
                .buildAndExpand(42);

        URI uri = uriComponents.encode().toUri();




        return "uri";

    }


}
