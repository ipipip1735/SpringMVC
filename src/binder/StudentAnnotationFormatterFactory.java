package binder;

import dao.Student;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Administrator on 2019/9/17 11:31.
 */
public class StudentAnnotationFormatterFactory implements AnnotationFormatterFactory<StudentFormat> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        System.out.println("~~" + getClass().getSimpleName() + ".getFieldTypes~~");
        Set<Class<?>> fieldTypes = new HashSet<>(4);
        fieldTypes.add(Student.class);
        return fieldTypes;
    }

    @Override
    public Printer<Student> getPrinter(StudentFormat annotation, Class<?> fieldType) {
        System.out.println("~~" + getClass().getSimpleName() + ".getParser~~");

        return new Printer<Student>() {
            @Override
            public String print(Student object, Locale locale) {
                System.out.println("~~" + getClass().getSimpleName() + ".print~~");
                System.out.println("object is " + object);
                System.out.println("locale is " + locale);
                return object.toString();
            }
        };
    }

    @Override
    public Parser<Student> getParser(StudentFormat annotation, Class<?> fieldType) {
        System.out.println("~~" + getClass().getSimpleName() + ".getPrinter~~");

        System.out.println("fieldType is " + fieldType);
        System.out.println("annotation is " + annotation);

        System.out.println("name is " + annotation.name());
        System.out.println("sno is " + annotation.sno());

        return new Parser<Student>() {
            @Override
            public Student parse(String text, Locale locale) throws ParseException {
                System.out.println("~~" + getClass().getSimpleName() + ".parse~~");
                System.out.println("text is " + text);
                System.out.println("locale is " + locale);

                return new Student(annotation.sno(), annotation.name());
            }
        };
    }

}
