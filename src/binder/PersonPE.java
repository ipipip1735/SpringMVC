package binder;

import dao.Person;

import java.beans.PropertyEditorSupport;

/**
 * Created by Administrator on 2019/9/6 16:43.
 */
public class PersonPE extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("~~" + getClass().getSimpleName() + ".setAsText~~");

        Person person = new Person();
        System.out.println(person);
        setValue(person);
    }
}