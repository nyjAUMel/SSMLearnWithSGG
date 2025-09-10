package com.atguigu.spring.ioc.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-09 19:03
 */
@Data
public class User implements InitializingBean, DisposableBean {
    private String username;
    private String password;

    private Car car;

    @Autowired
    public void set(@Qualifier("BYDFactory")Car car){
        System.out.println("Car注入了");
        this.car = car;
    }

    public User()
    {
        System.out.println("User构造器执行");
    }

    /*
    * 构造器执行之后调用
    * */
    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct...");
    }

    /*
    * 销毁之前调用
    * */
    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy...");
    }

    public void initUser(){
        System.out.println("UserBean初始化");
    }

    public void destroyUser() {
        System.out.println("UserBean销毁用户");
    }

    /*
    * 属性设置之后调用：set方法赋值完成
    *  */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 调用 afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitializingBean 调用 destroy");
    }
}
