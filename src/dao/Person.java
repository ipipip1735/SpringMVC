package dao;

import javax.validation.constraints.Min;
import java.beans.ConstructorProperties;
import java.io.Serializable;

/**
 * Created by Administrator on 2019/9/4 15:48.
 */
public class Person{


    String name;

    @Min(15)
    int age;

    public Person() {
        age = -1;
        name = "XX";
    }

    public void setAge(int age) {
        System.out.println("~~" + getClass().getSimpleName() + ".setAge~~");
        System.out.println("age is " + age);
        this.age = age;
    }

    public void setName(String name) {
        System.out.println("~~" + getClass().getSimpleName() + ".setName~~");
        System.out.println("name is " + name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


}
