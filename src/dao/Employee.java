package dao;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/9/30 11:13.
 */
public class Employee implements Serializable{

    private String name;
    private long id;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
