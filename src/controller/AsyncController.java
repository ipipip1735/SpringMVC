package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.SocketUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.socket.TextMessage;

import java.util.function.Consumer;

/**
 * Created by Administrator on 2019/12/12 13:15.
 */
@RestController
public class AsyncController {

    @GetMapping("/async")
    public ListenableFuture<String> async() {
        System.out.println("async start");
        System.out.println(Thread.currentThread());


        AsyncResult<String> asyncResult = new AsyncResult<>("oo");
        asyncResult.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("~~onFailure~~");
                System.out.println("ex is " + ex);
                System.out.println(Thread.currentThread());
            }

            @Override
            public void onSuccess(String result) {
                System.out.println("~~onSuccess~~");
                System.out.println(Thread.currentThread());
                System.out.println("result is " + result);
            }
        });


        System.out.println("async end");

        return asyncResult;
    }


//    @GetMapping("/async")
//    public DeferredResult<String> async() {
//        System.out.println("~~async|start~~");
//
//
//        DeferredResult<String> deferredResult = new DeferredResult();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000L);
//
//
////                    deferredResult.setResult("ok");
////                    System.out.println("complete!");
//
//
////                    deferredResult.setErrorResult(new Exception("xxx"));
////                    System.out.println("complete!");
//
//
//                    throw new Exception("xxx");
//
//
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        deferredResult.onCompletion(()->{
//            System.out.println("~~onCompletion~~");
//        });
//
//        deferredResult.onTimeout(()->{
//            System.out.println("~~onTimeout~~");
//        });
//
//        deferredResult.onError(new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) {
//                System.out.println("~~onError~~");
//                System.out.println(throwable);
//            }
//        });
//
//
//        System.out.println("~~async|end~~");
//
//
//        return deferredResult;
//    }


}
