package service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Created by Administrator on 2019/12/13 13:58.
 */
@EnableAsync
@Service("asyncService")
public class AsyncService {

    public AsyncService() {
        System.out.println("*********  " + getClass() + ".Constructor  *********");
    }

    @Async
    public ListenableFuture<String> task() {

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new AsyncResult<>("oo");
    }
}
