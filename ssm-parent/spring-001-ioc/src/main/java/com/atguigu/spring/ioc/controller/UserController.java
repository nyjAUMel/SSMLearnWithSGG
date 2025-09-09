package com.atguigu.spring.ioc.controller;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.service.UserService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-08 14:54
 */
@ToString
@Controller
public class UserController {

    /*
    @Component → 把类放进容器，变成 Bean。
    @Autowired → 从容器里拿 Bean 来用。

    自动装配流程
        1. 按照类型，找到这个组件
            1.0、只有找到这一个组件，名字无所谓。
            1.1、如果找到多个，按照属性名，找到对应的组件
     */
    @Autowired
    private UserService userService;

    @Autowired
    private Person lisi;

    /*
    将容器中所有Person取出来存入到这个集合当中
     */
    @Autowired
    private List<Person> personList;

    /*
    将容器中所有Person取出来存入到这个Map当中
        其中，名为key，值为value
     */
    @Autowired
    private Map<String,Person> personMap;

    // 也可以把IOC容器拿过来
    @Autowired
    private ApplicationContext applicationContext;
}
