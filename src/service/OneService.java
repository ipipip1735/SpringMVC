package service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/9/1 8:39.
 */
@Service("oneSB")
public class OneService {

    public OneService() {
        System.out.println("*********  " + getClass() + ".Constructor  *********");
    }
}
