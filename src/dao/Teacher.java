package dao;

import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2019/9/18 13:34.
 */
public class Teacher {

    @Autowired
    private Validator validator;

    @Min(value = 10)
//    @Min(value = 10, message = "xxxx")
    int age;

    public int getAge() {
        System.out.println("~~" + getClass().getSimpleName() + ".getAge~~");

        return age;
    }

    public void setAge(int age) {
        System.out.println("~~" + getClass().getSimpleName() + ".setAge~~");

        System.out.println(validator);
        this.age = age;
    }
}
