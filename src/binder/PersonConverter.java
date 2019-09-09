package binder;

import dao.Person;

/**
 * Created by Administrator on 2019/9/9 20:02.
 */
public class PersonConverter {
    public PersonConverter() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    public Person convert(String source) {
        System.out.println("~~" + getClass().getSimpleName() + ".convert~~");
        return new Person();
    }
}
