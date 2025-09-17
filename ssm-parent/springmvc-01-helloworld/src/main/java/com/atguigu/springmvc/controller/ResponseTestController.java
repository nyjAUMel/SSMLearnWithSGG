package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.bean.Person;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-13 11:29
 */
@RestController
public class ResponseTestController {

    /**
     * SpringMVC 自动将对象转为JSON
     *
     * @return
     */
    @RequestMapping("/resp01")
    public Person resp01() {
        Person person = new Person();
        person.setUsername("蔡徐坤");
        person.setPassword("111");
        person.setCellphone("222");
        person.setAgreement(false);
        person.setSex("男");
        person.setHobby(new String[]{"看电影", "看小说"});
        person.setGrade("八年级");

        // SpringMVC会自动把对象转为JSON
        return person;
    }

    /**
     * 文件下载
     * HttpEntity：拿到整个请求数据
     * ResponseEntity：拿到整个响应数据
     *
     * @return
     */
    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> download() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/niuyujie/cc美/v2-5ced1f89e08aaaa6e28711cbebd6a419_r.jpg");
        byte[] bytes = fileInputStream.readAllBytes();

        // 1. 返回的文件名包含中文会乱码，解决：把下面这个变量填写到header第二个参数
        String encode = URLEncoder.encode("哈哈.jpg", "UTF-8");
        // 2. 文件太大会oom（内存溢出）
        InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);

        return ResponseEntity.ok()
                // 内容类型
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                // 内容大小
                .contentLength(bytes.length)
                // Content-Disposition 内容处理方法
                .header("Content-Disposition", "attachment;filename" + encode)
                .body(inputStreamResource);
    }
}
