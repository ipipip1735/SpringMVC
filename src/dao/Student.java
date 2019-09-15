package dao;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * Created by Administrator on 2019/9/5 5:09.
 */
public class Student {

    @DateTimeFormat(pattern = "yyyy")
    private Date birthday;



    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public Date getBirthday() {
        return birthday;
    }

    public Student() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

}
