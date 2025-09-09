package com.atguigu.spring.ioc.service;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.dao.UserDao;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-08 14:55
 */
@Data
@ToString
@Service
public class UserService {

    /*
    如果存在多个相同类型的bean，@Qualifier指定精确的名字注入
    当然，新版的Spring直接可以通过写相同的变量名，Spring会自动注入。
        补充：如果不指定@Qualifier也不写相同的变量名，那么可以在配置类中，使用@Primary指定默认的bean。
                而且@Primary一旦指定，就不能通过变量名注入了
     */
    @Qualifier("bill")
    @Autowired
    private Person person;

    /*
    @Resource 和 @Autowired 的主要区别如下：
        来源不同：
            @Resource：是Java标准注解（JSR-250规范），来自 jakarta.annotation 包
            @Autowired：是Spring框架特有的注解，来自 org.springframework.beans.factory.annotation 包
        装配方式不同：
            @Resource：默认按名称装配，如果找不到则按类型装配
            @Autowired：默认按类型装配
        属性支持不同：
            @Resource：支持 name 和 type 属性
            @Autowired：通常配合 @Qualifier 注解来指定具体的bean名称
        使用位置：
            两者都可以用在字段、setter方法和构造函数上
     */
    @Resource
    private UserDao userDao;
}
