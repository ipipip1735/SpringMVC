package dao;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Administrator on 2019/12/20 9:39.
 */
//@Component
////@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
//public class Cat {
//    public Cat() {
//        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
//    }
//
//    @PostConstruct
//    public void init() {
//        System.out.println("~~~~  " + getClass().getSimpleName() + ".init  ~~~~");
//    }
//
//    @PreDestroy
//    public void destroy() {
//        System.out.println("~~~~  " + getClass().getSimpleName() + ".destroy  ~~~~");
//    }
//}



@Component
//@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cat {
    public Cat() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public void init() {
        System.out.println("~~~~  " + getClass().getSimpleName() + ".init  ~~~~");
    }

    public void destroy() {
        System.out.println("~~~~  " + getClass().getSimpleName() + ".destroy  ~~~~");
    }
}
