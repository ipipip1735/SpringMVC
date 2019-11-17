package controller;

import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT;


/**
 * S
 * Created by Administrator on 2019/10/4 16:10.
 */
@RestController
public class RestAPIController {

    /**
     * 使用模板
     * 使用exchange()完成请求，传递请求主体，获取响应实体
     */
//    @GetMapping("/restapi")
//    public Object restTemplat() {
//
//        //使用模板
//        String baseUrl = "https://example.com";
//        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUrl);
//        uriBuilderFactory.setEncodingMode(URI_COMPONENT);
//
//
//        RequestEntity requestEntity = null;
//        try {
//            requestEntity = RequestEntity.get(new URI(baseUrl))
//                    .build();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setUriTemplateHandler(uriBuilderFactory);
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
//        String body = responseEntity.getBody();
//        System.out.println(body);
//        return responseEntity;//返回响应实体
//        //return body; //返回主体
//    }


    /**
     * 使用模板
     * 使用execute()完成请求，传递请求主体，获取响应实体
     */
//    @GetMapping("/restapi")
//    public Object restTemplat() {
//
//        String baseUrl = "http://example.com";
////        String baseUrl = "http://example.com/{aa}?q={xx}";
//        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUrl);
//        uriBuilderFactory.setEncodingMode(URI_COMPONENT);
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setUriTemplateHandler(uriBuilderFactory);
//
//        RequestCallback requestCallback = new RequestCallback() {
//            @Override
//            public void doWithRequest(ClientHttpRequest request) throws IOException {
//                System.out.println("~~doWithRequest~~");
//
//                System.out.println("getBody is " + request.getBody());
//                System.out.println("getHeaders is " + request.getHeaders());
//                System.out.println("getMethodValue is " + request.getMethodValue());
//                System.out.println("getMethod is " + request.getMethod());
//                System.out.println("getURI is " + request.getURI());
//
//                request.getHeaders().put("one", Arrays.asList("111"));
//
//
//            }
//        };
//
//        ResponseExtractor responseExtractor = new ResponseExtractor() {
//            @Override
//            public Object extractData(ClientHttpResponse response) throws IOException {
//                System.out.println("~~extractData~~");
//                System.out.println("getStatusText is " + response.getStatusText());
//                System.out.println("getRawStatusCode() is " + response.getRawStatusCode());
//                System.out.println("getStatusCode() is " + response.getStatusCode());
//                System.out.println("getBody is " + response.getBody());
//                System.out.println("getHeaders is " + response.getHeaders());
//
//                int size = response.getBody().available();
//                System.out.println("size is " + size);
//
//                return size;
//            }
//        };
//
//        return restTemplate.execute(baseUrl, HttpMethod.GET, requestCallback, responseExtractor);
////        return restTemplate.execute(baseUrl, HttpMethod.GET, requestCallback, responseExtractor, "one", 11);
//
//    }


    /**
     * 使用webClinet
     * 使用execute()完成请求，传递请求主体，获取响应实体
     */
    @GetMapping("/restapi")
    public void webClinet(Model model) {

        String baseUrl = "https://example.org";
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);



    }

}
