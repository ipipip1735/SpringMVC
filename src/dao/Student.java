package dao;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * Created by Administrator on 2019/9/5 5:09.
 */
public class Student {


    @DateTimeFormat(pattern = "yyyyMM")
    private Date birthday;


    public void setBirthday(Date birthday) {
        System.out.println("~~" + getClass().getSimpleName() + ".setBirthday~~");
        this.birthday = birthday;
        System.out.println(this.birthday);
    }


    public Date getBirthday() {
        System.out.println("~~" + getClass().getSimpleName() + ".getBirthday~~");
        return birthday;
    }

    public Student() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

}
