package controller;

import dao.Person;
import io.netty.channel.ChannelOption;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.JettyClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.*;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.CacheResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.springframework.web.reactive.function.BodyInserters.fromFormData;
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
    public Mono<String> webClinet() {

//        return create();//使用create()创建
//        return build();//使用构建器

//        return retrieve();//获取数据
        return exchange();//交换实体对象

//        return error(); // 错误处理

//        return form();//表单处理

    }


    private void form() {


        //方式一：普通表单
//        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//        formData.add("k1", "v1");
//        formData.add("k2", "v2");
//
//        Mono<Void> result =  WebClient.create("https://example.org")
//                .post()
//                .uri("/path")
//                .bodyValue(formData)
//                .retrieve()
//                .bodyToMono(Void.class);

        //方式一：普通表单
//        Mono<Void> result = WebClient.create("https://example.org")
//                .post()
//                .uri("/path")
//                .body(fromFormData("k1", "v1").with("k2", "v2"))//使用工具方法
//                .retrieve()
//                .bodyToMono(Void.class);


        //方式二：复合表单
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("fieldPart", "fieldValue");
        builder.part("filePart1", new FileSystemResource("...logo.png"));
        builder.part("jsonPart", new Person());

        MultiValueMap<String, HttpEntity<?>> parts = builder.build();

        Mono<Void> result = WebClient.create("https://example.org")
                .post()
                .uri("/path", 12)
                .bodyValue(parts)
                .retrieve()
                .bodyToMono(Void.class);


    }

    private Mono<String> exchange() {


        return WebClient.create("https://example.org")
                .get()
                .exchange()
                .flatMap(clientResponse -> {
                    System.out.println(clientResponse);


//                    //方式一：获取响应主体
//                    return clientResponse.bodyToMono(String.class)
//                            .doOnNext(System.out::println);


                    //方式二：获取响应实体
                    return clientResponse.toEntity(String.class)
                            .flatMap(stringResponseEntity -> {
                                System.out.println(stringResponseEntity);
                                System.out.println("getStatusCode is " + stringResponseEntity.getStatusCode());
                                System.out.println("getStatusCodeValue is " + stringResponseEntity.getStatusCodeValue());
                                System.out.println("getHeaders is " + stringResponseEntity.getHeaders());
                                System.out.println("getBody is " + stringResponseEntity.getBody());

                                return Mono.just(stringResponseEntity.getBody());
                            });


                    //方式三：
//                    clientResponse.releaseBody();//抛弃响应主体
//                    return Mono.just("OK");


                    //方式四：错误处理
//                    return clientResponse.toEntity(String.class)
//                            .flatMap(stringResponseEntity -> {
//                                if (stringResponseEntity.getStatusCode().is4xxClientError())
//                                    return Mono.just("4XX Error");
//                                    return Mono.just("5XX Error");
//                            });
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

    private Mono<String> retrieve() {

        return WebClient.create()
                .get()
                .uri("https://example.org")
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(System.out::println);
    }

    private Mono<String> build() {

        WebClient webClient = null;

        //配置客户端及连接器
//        String baseUrl = "https://example.org";
//        HttpClient httpClient = HttpClient.create()//创建客户端
//                .keepAlive(true)
//                .compress(true);
//
//        webClient =WebClient.builder()
//                .baseUrl(baseUrl)
//                .clientConnector(new ReactorClientHttpConnector(httpClient))
//                .build();


        //配置过滤器
//        String baseUrl = "https://example.org";
//
//        webClient = WebClient.builder()
//                .filter((clientRequest, next) -> {
//                    System.out.println("~~filter1~~");
//                    System.out.println(clientRequest);
//                    System.out.println(next);
//
//                    System.out.println("headers is " + clientRequest.headers());
//
//                    ClientRequest request = ClientRequest.from(clientRequest)
//                            .header("foo", "bar")
//                            .build();
//
//                    Mono<ClientResponse> mono = next.exchange(request)
//                            .doOnNext(clientResponse -> {
//                                System.out.println("~~filter1.doOnNext~~");
//                                System.out.println(clientResponse);
//                                System.out.println(clientResponse.statusCode());
//                            });
//
//                    return mono;
//                })
//                .filter((clientRequest, next) -> {
//                    System.out.println("~~filter2~~");
//
//                    System.out.println(clientRequest.headers());
//
//                    return next.exchange(clientRequest)
//                            .doOnNext(clientResponse -> {
//                                System.out.println("~~filter2.doOnNext~~");
//                                System.out.println(clientResponse);
//                                System.out.println(clientResponse.statusCode());
//                            });
//                })
//                .filters(exchangeFilterFunctions -> {//增加到过滤链的任意位置
//                    exchangeFilterFunctions.add(0, ExchangeFilterFunctions.basicAuthentication("uu", "xx"));
//                    exchangeFilterFunctions.add(1, ((request, next) -> {
//                        System.out.println("~~filter3~~");
//                        return next.exchange(request);
//                    }));
//                })
//                .baseUrl(baseUrl)
//                .build();
//
//
        return webClient.get()
                .retrieve()
                .toEntity(String.class)
                .flatMap(stringResponseEntity -> {
                    System.out.println("~~subscribe~~");
                    System.out.println(stringResponseEntity.getStatusCode());
                    System.out.println(stringResponseEntity.getHeaders());
                    System.out.println(stringResponseEntity.getBody().length());

                    return Mono.just(stringResponseEntity.getBody());
                });


        //配置URL编码模式
//        String baseUrl = "https://example.org";
//        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
//        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES);

    }

    private Mono<String> create() {

        return WebClient.create()
                .get()
                .uri("https://example.org")
                .retrieve()
                .bodyToMono(String.class);

    }

}
