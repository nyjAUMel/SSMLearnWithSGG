package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-13 14:50
 */

/**
 * SpringBoot整合的SpringMVC不支持JSP
 * 1. 引入thymeleaf作为模板引擎，渲染页面
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-thymeleaf</artifactId>
 * </dependency>
 * 2. 默认规则：
 * 页面放到：src/main/resources/templates
 * 静态资源(js、css等)放到：src/main/resources/static
 */
@Controller // 开发服务端渲染逻辑
public class PageTestController {

    /**
     * 处理 / 请求，跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        /*
        thymeleaf默认会去 classpath:/templates 下找页面
        页面地址 = classpath:/templates/+ 返回名字 + .html
        */
        return "login"; // 返回值就是页面名称（视图）
    }

    @RequestMapping("/login.do")
    public String login(String username, String password,
                            /*
                            用于在控制器(Controller)和视图(View)之间传递数据
                            将控制器处理的数据存储到Model中，供视图页面使用
                            Model中的数据会自动添加到请求(request)作用域中，视图页面可以直接访问这些数据
                             */
                        Model model) {
        List<User> list = Arrays.asList(
                new User(1L, "张三", 15),
                new User(2L, "李四", 19),
                new User(3L, "王五", 20),
                new User(4L, "赵六", 12),
                new User(5L, "孙七", 22),
                new User(6L, "周八", 17),
                new User(7L, "吴九", 24),
                new User(8L, "郑十", 11)
        );

        model.addAttribute("users", list);
        model.addAttribute("username", username);
        model.addAttribute("age", 18);
        return "pages/success";
    }
}
