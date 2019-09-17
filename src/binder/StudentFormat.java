package binder;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2019/9/17 9:37.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface StudentFormat {
    String name() default "xx";
    int sno() default -1;
}
