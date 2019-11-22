package controller;

import dao.Person;
import io.netty.channel.ChannelOption;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

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

    String r = null;

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
    public String webClinet(Model model) {

//        create();//使用create()创建
//        build();//使用构建器

//        r = retrieve();//检索

//        error(); // 错误处理

        exchange();

        return r;

    }

    private void exchange() {

        WebClient.create("https://example.org")
                .get()
                .exchange()
                .subscribe(clientResponse -> {
                    System.out.println(clientResponse);

//                    clientResponse.bodyToMono(String.class)
//                    .subscribe(System.out::println);
//                    System.out.println("end");

                    clientResponse.toEntity(String.class)
                    .subscribe(stringResponseEntity -> {
                        System.out.println(stringResponseEntity);
                        System.out.println("getStatusCode is " + stringResponseEntity.getStatusCode());
                        System.out.println("getStatusCodeValue is " + stringResponseEntity.getStatusCodeValue());
                        System.out.println("getHeaders is " + stringResponseEntity.getHeaders());
                        System.out.println("getBody is " + stringResponseEntity.getBody());
                    });

//                    clientResponse.releaseBody();//抛弃响应主体

//                    System.out.println("cookies is " + clientResponse.cookies());
//                    System.out.println("headers is " + clientResponse.headers());
//                    System.out.println("statusCode is " + clientResponse.statusCode());


//                    ExchangeStrategies exchangeStrategies = clientResponse.strategies();


//                    clientResponse.toEntity(String.class)
//                            .subscribe(System.out::println);


                });


    }

    private void error() {

        String r = WebClient.create()
                .get()
                .uri("https://example.org")
                .retrieve()
                .onStatus(httpStatus -> {
                    System.out.println("~~onStatus~~");
                    System.out.println(httpStatus);
                    return true;
                }, clientResponse -> {
                    System.out.println("~~handle~~");
                    System.out.println(clientResponse);
                    return Mono.just(new Throwable());
                })
                .bodyToMono(String.class)
                .block();
        System.out.println(r);
    }

    private String retrieve() {

        return WebClient.create()
                .get()
                .uri("https://example.org")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private void build() {
        //        HttpClient httpClient = HttpClient.create();
//        WebClient client = WebClient.builder()
//                .clientConnector(new ReactorClientHttpConnector(httpClient))
//                .build();


//        String baseUrl = "https://example.org";
//        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
//        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);
//
//
//
//        HttpClient httpClient = HttpClient.create()
//                .tcpConfiguration(client ->
//                        client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000));
    }

    private void create() {

        WebClient.create()
                .get()
                .uri("https://example.org")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println);

    }

}
