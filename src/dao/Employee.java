package dao;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/9/30 11:13.
 */
public class Employee implements Serializable{


    @Size(min = 12)
    private String name;
    private long id;
    private boolean sex;
    private List<String> interests;

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isSex() {
        return sex;
    }

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
