package binder;

import dao.Person;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * Created by Administrator on 2019/9/6 16:42.
 */
public class OnePropertyEditorRegistrar implements PropertyEditorRegistrar {

    public OnePropertyEditorRegistrar() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }



    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        System.out.println("~~" + getClass().getSimpleName() + ".registerCustomEditors~~");

        registry.registerCustomEditor(Person.class, new PersonPE());
    }
}