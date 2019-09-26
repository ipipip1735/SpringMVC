package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by Administrator on 2019/9/26 11:43.
 */
@Controller
public class UriController {


//    @GetMapping("/uri")
//    public void uri(Model model) {
//
//
//        //简单使用
//        UriComponents uriComponents = UriComponentsBuilder
//                .fromUriString("https://example.com/hotels/{hotel}")
//                .queryParam("q", "{q}")
//                .build();
//        URI uri = uriComponents.expand("Westin", "123").toUri();
//        System.out.println(uri);
//
//
//        //简化使用
////        URI uri = UriComponentsBuilder
////                .fromUriString("https://example.com/hotels/{hotel}")
////                .queryParam("q", "{q}")
////                .build("Westin", "123");
//
//
//        //使用工厂
////        String baseUrl = "https://example.com";
////        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUrl);
////        URI uri = uriBuilderFactory.uriString("/hotels/{hotel}")
////                .queryParam("q", "{q}")
////                .build("Westin", "123");
//
//
//        //使用 REST URL
////        String baseUrl = "https://example.org";
////        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
////        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
////
////        RestTemplate restTemplate = new RestTemplate();
////        restTemplate.setUriTemplateHandler(factory);
////        restTemplate.get
//
//
//        model.addAttribute("uri", uri);
//    }


//    @GetMapping("/uri")
//    public void webClinet(Model model) {
//
////        String baseUrl = "https://example.org";
////        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
////        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
////        WebClient
//    }



    @GetMapping("/uri")
    public void uriEncoding(Model model) {

        //URI编码
//        URI uri = UriComponentsBuilder.fromUriString("https://example.com/ho:t;e&l s/{hotel}")
//                .queryParam("q", "{q}")
//                .encode()
//                .build()
//                .expand("We:s;t&in", "12<3")
//                .toUri();


        URI uri = UriComponentsBuilder.fromUriString("https://example.com/ho:t;e&l s/{hotel}")
                .queryParam("q", "{q}")
                .build()
                .expand("We:s;t&in", "12<3")
                .encode()
                .toUri();


        model.addAttribute("uri", uri);

    }


}
