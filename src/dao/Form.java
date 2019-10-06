package dao;

import org.springframework.web.multipart.MultipartFile;

import java.beans.ConstructorProperties;

/**
 * Created by Administrator on 2019/9/5 5:09.
 */
public class Form {
    private MultipartFile file;

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }
}
