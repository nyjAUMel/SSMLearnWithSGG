package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-08 14:49
 */
@Configuration // 告诉Spring容器，这是一个配置类
public class PersonConfig {

    /**
     * @Scope 调整组件的作用域：
     *  1、@Scope("prototype")：非单实例
     *      什么时候获取什么时候创建对象
     *  2、@Scope("singleton")：单实例（默认）
     *      容器启动的时候就会创建对象，以后每次获取都是同一个对象
     *     通常配合使用@Lazy：懒加载，容器启动的时候不创建对象，第一次使用（获取）的时候创建对象
     *  3、@Scope("request")：一次请求创建一个实例
     *  4、@Scope("session")：一次会话创建一个实例
     * @return
     */
    @Scope("prototype")
    @Bean("ppp")
    public Person person1() {
        Person person = new Person();
        person.setName("Sheldon");
        person.setAge(0);
        person.setGender("男");
        return person;
    }

    @Bean("lisi")
    public Person person2() {
        Person person = new Person();
        person.setName("Cooper");
        person.setAge(0);
        person.setGender("男");
        return person;
    }
}
