package binder;

import dao.Person;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * Created by Administrator on 2019/9/11 15:06.
 */
public class TwoPropertyEditorRegistrar implements PropertyEditorRegistrar {

    public TwoPropertyEditorRegistrar() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }



    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        System.out.println("~~" + getClass().getSimpleName() + ".registerCustomEditors~~");

        System.out.println(this);
        registry.registerCustomEditor(Person.class, new PersonPE());
    }
}