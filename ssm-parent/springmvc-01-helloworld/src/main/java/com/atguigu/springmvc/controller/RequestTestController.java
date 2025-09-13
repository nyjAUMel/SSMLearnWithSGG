package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 21:17
 */
@RestController
public class RequestTestController {

    /**
     * 请求参数：http://localhost:9999/handle01?username=AU&password=123&cellphone=1234456&agreement=true
     * 要求：变量名和参数名要一致
     * 1. 没有携带：包装类型自动封装为null，基本类型封装为默认值
     * 2. 携带：自动封装
     *
     * @return
     */
    @RequestMapping("/handle01")
    public String handle01(String username, String password, String cellphone, boolean agreement) {
        System.out.println("name = " + username);
        System.out.println("pwd = " + password);
        System.out.println("phone = " + cellphone);
        System.out.println("agreement = " + agreement);
        return "ok";
    }

    /**
     * 请求参数：http://localhost:9999/handle02?username=AU&password=123
     *
     * @RequestParam()：被该注解修饰的参数发送请求时一定要有 required = false：表示可以不携带
     * @RequestParam("username")表示：将请求参数中的username赋值给变量name 无论请求参数在请求体还是url后面，它们都是请求参数。都可以直接用@RequestParam注解修饰，直接封装为参数。
     */
    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name
            , @RequestParam("password") String pwd
                           // defaultValue：默认值，表示该参数是可选的，请求中可以不携带pwd 参数，默认为abc
            , @RequestParam(value = "cellphone", defaultValue = "abc") String phone
                           // 表示该参数是可选的，请求中可以不携带 agm 参数，默认为true
            , @RequestParam(value = "agm", required = false) boolean agreement) {
        System.out.println("name = " + name);
        System.out.println("pwd = " + pwd);
        System.out.println("phone = " + phone);
        System.out.println("agreement = " + agreement);
        return "ok";
    }

    /**
     * 如果目标方法参数是一个pojo，SpringMVC会自动把请求参数和pojo属性进行匹配
     * 效果：
     * 1. pojo的所有属性值都是来自于请求参数
     * 2. 如果请求参数没带或参数名和属性名不一致，封装为null
     *
     * @param person
     * @return
     */
    @RequestMapping("/handle03")
    public String handle03(Person person) {
        System.out.println(person);
        return "ok";
    }


    /**
     * @param host
     * @return
     * @RequestHeader()：获取请求头信息，参数名要和请求头的名称一致（不区分大小写）
     * @RequestHeader("host")：表示获取请求头中的host值
     */
    @RequestMapping("/handle04")
    public String handle04(@RequestHeader("host") String host,
                           @RequestHeader(value = "user-agent", required = false, defaultValue = "AAA") String connection) {
        System.out.println(host);
        return "ok";
    }


    /**
     * 在 Spring MVC 中，提供了专门的 @CookieValue 注解来处理 Cookie 数据。
     * 功能区分：
     *
     * @param cookie
     * @return
     * @RequestHeader：用于获取请求头中的任意字段。
     * @CookieValue：专门用于提取和解析 Cookie 信息。
     */
    @RequestMapping("/handle05")
    public String handle05(@CookieValue("_ga") String cookie) {
        System.out.println(cookie);
        return "ok";
    }


    /**
     * 使用pojo级联封装复杂属性
     * 请求链接：http://localhost:9999/handle06?username=AU&password=123456&cellphone=13800138000&agreement=true&address.province=SX&address.city=XZ&address.area=XF&hobby=reading&hobby=swimming&hobby=running&sex=male&grade=3
     *
     * @param person
     * @return
     */
    @RequestMapping("/handle06")
    public String handle06(Person person) {
        System.out.println(person);
        return "ok";
    }


    /**
     * 接受JSON数据
     *
     * @param person
     * @return
     * @RequestBody：获取请求体中的JSON数据，将其自动封装为对象
     */
    @RequestMapping("/handle07")
    public String handle07(@RequestBody Person person) {
        System.out.println(person);
        return "ok";
    }


    /**
     * 接受上传的文件：
     * MultipartFile：SpringMVC提供的一个接口，封装了上传的文件
     *
     * @param person
     * @return
     */
    @RequestMapping("/handle08")
    public String handle08(Person person,
                           // 表示取出请求参数中的headerImg，并将其封装为单文件对象
                           @RequestParam("headerImg") MultipartFile file,
                           // 对于多文件的封装
                           @RequestParam("lifeImg") MultipartFile[] files
    ) {
        // 1. 获取原始文件名
        String originalFilename = file.getOriginalFilename();

        // 2. 获取文件大小
        long size = file.getSize();

        // 3. 获取文件内容
        try {
            InputStream inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "ok";
    }


    /**
     * HttpEntity 是 Spring MVC 提供的一个通用 HTTP 实体类，用于封装完整的 HTTP 请求或响应信息。
     * HttpEntity 的泛型类型决定了请求体（Body）的数据类型和处理方式：
     * 指定请求体类型：
     * HttpEntity<String>：请求体被当作字符串处理
     * HttpEntity<Person>：请求体被自动转换为 Person 对象
     *
     * @param httpEntity
     * @return
     */
    @RequestMapping("/handle09")
    public String handle09(HttpEntity<Person> httpEntity) {
        // 1. 获取请求头
        HttpHeaders headers = httpEntity.getHeaders();
        System.out.println("headers = " + headers);

        // 2. 获取请求体
        Person body = httpEntity.getBody();
        System.out.println("body = " + body);
        return "ok";
    }


    /**
     * 接受原生API
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/handle10")
    public void handle10(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(request.getParameter("username"));
    }
}
