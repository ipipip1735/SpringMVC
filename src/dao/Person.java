package dao;

/**
 * Created by Administrator on 2019/9/4 15:48.
 */
public class Person {
    int age = 123;
    String name = "XX";

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        System.out.println("~~" + getClass().getSimpleName() + ".handle~~");

        return name;
    }
}
