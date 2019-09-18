package dao;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;


/**
 * Created by Administrator on 2019/9/5 5:09.
 */
public class Student {

    int sno;
    String name;

    @DateTimeFormat(pattern = "yyyyMMdd")
    Date birthday = new Date(0L);

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }
    public int getSno() {
        return sno;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Student() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        this.sno = -1;
        this.name = "xx";
    }

    public Student(int sno, String name) {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        this.sno = sno;
        this.name = name;
    }

}
