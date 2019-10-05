package controller;

import dao.Employee;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2019/9/30 11:07.
 */
@Controller
public class MultipartFormController {


    //方式二：使用标签库
    @GetMapping("/multipart")
    public String multipart() {
        System.out.println("~~" + getClass().getSimpleName() + ".multipart~~");

        return "multipartForm";
    }


    @PostMapping(value = "/uploadFile")
    public void submit(@RequestParam("file") MultipartFile file) {



        System.out.println(file);

    }

}