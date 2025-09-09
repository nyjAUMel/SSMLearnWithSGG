package com.atguigu.spring.ioc.dao;

import com.atguigu.spring.ioc.bean.Dog;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-08 14:55
 */
@ToString
@Repository
public class UserDao {

    Dog hh;

    /*
    Spring会自动从容器中找到构造器所需要的所有参数。

    所以这个也叫利用构造器自动注入。
    推荐这种方式
     */
    public UserDao(@Qualifier("dog1") Dog dog) {
        System.out.println("UserDao有参构造器");
        this.hh = dog;
    }

    /*
     利用setter方法进行注入

     构造器注入的优先级更高，但set因为是后面注入的所以会覆盖前面的构造器注入
     */
    @Autowired
    public void setHh(@Qualifier("dog2") Dog hh) {
        this.hh = hh;
    }
}
