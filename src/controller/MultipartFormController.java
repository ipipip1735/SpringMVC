package controller;

import dao.Employee;
import dao.Form;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2019/9/30 11:07.
 */
@Controller
public class MultipartFormController {

    @Autowired
    Environment environment;


    @GetMapping("/multipart")
    public String multipart() {
        System.out.println("~~" + getClass().getSimpleName() + ".multipart~~");

        return "multipartForm";
    }




    //表单字段
    @PostMapping(value = "/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile xx, @RequestParam("name") String name) {
        System.out.println("~~" + getClass().getSimpleName() + ".uploadFile~~");

        System.out.println("name is " + name);

        try {
            System.out.println("getContentType is " + xx.getContentType());
            System.out.println("getOriginalFilename is " + xx.getOriginalFilename());
            System.out.println("getSize is " + xx.getSize());
            System.out.println("getName is " + xx.getName());
            System.out.println("length is " + xx.getBytes().length);
            System.out.println("getResource is " + xx.getResource());
            System.out.println("isEmpty is " + xx.isEmpty());

            System.out.println("getInputStream is " + xx.getInputStream());
            System.out.println("getInputStream is " + xx.getInputStream());

            xx.transferTo(new File(environment.getProperty("CATALINA_TMPDIR"), "upload/" + new Random().nextInt(100) + ".txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //多文件上传，使用Map容器
//    @PostMapping(value = "/uploadFile")
////    public void uploadFile(@RequestParam Map<String, MultipartFile> multipartFileMap) {
////        System.out.println("~~" + getClass().getSimpleName() + ".uploadFile~~");
////
////        for (String s : multipartFileMap.keySet()) {
////            System.out.println(s);
////        }
////    }
//    public void uploadFile(@RequestParam MultiValueMap<String, MultipartFile> multipartFileMultiValueMap) {
//        System.out.println("~~" + getClass().getSimpleName() + ".uploadFile~~");
//
//        for (String s : multipartFileMultiValueMap.keySet()) {
//            System.out.println(s);
//        }
//    }


    //使用Part接口
//    @PostMapping(value = "/uploadFile")
//    public void uploadFile(@RequestParam("file") Part part) {
//        System.out.println("~~" + getClass().getSimpleName() + ".uploadFile~~");
//
//        System.out.println("getContentType is " + part.getContentType());
//        System.out.println("getHeaders is " + part.getHeaders("Accept"));
//        System.out.println("getHeader is " + part.getHeader("Content-Language"));
//        System.out.println("getName is " + part.getName());
//        System.out.println("getHeaderNames is " + part.getHeaderNames());
//        System.out.println("getSize is " + part.getSize());
//        System.out.println("getSubmittedFileName is " + part.getSubmittedFileName());
//
//        try {
//
//            System.out.println("getInputStream is " + part.getInputStream().available());
//
//
//            File file = new File(environment.getProperty("CATALINA_HOME"), "upload/" + new Random().nextInt(100) + ".txt");
//            part.write(file.toString());
//            part.delete();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    //使用数据绑定
//    @PostMapping(value = "/uploadFile")
//    public void uploadFile(Form form, BindingResult errors) {
//        System.out.println("~~" + getClass().getSimpleName() + ".uploadFile~~");
//
//        try {
//            System.out.println(form.getFile().getInputStream().available());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


}