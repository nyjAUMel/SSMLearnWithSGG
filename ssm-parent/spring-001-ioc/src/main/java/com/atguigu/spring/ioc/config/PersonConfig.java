package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-08 14:49
 */
@Configuration // 告诉Spring容器，这是一个配置类
public class PersonConfig {

    /*
    场景：判断当前电脑的操作系统是Windows还是MacOS
        Windows系统容器中有bill
        MacOS系统容器中有jobs
     */
    // @Conditional 注解是 Spring 框架中的一个重要注解，用于根据特定条件来决定是否创建某个 Bean。
    //@Conditional(WindowsCondition.class)

    // 表示当容器中有jobs对象时，将这个bean放进容器当中
    //@ConditionalOnBean(name = "jobs")
    //@Lazy // 通常@Scope为默认单例时使用，因为非单例创建对象之有在获取时才创建对象。
    @Bean("jobs")
    public Person jobs(){
        Person person = new Person();
        person.setName("乔布斯");
        person.setAge(1);
        person.setGender("男");
        return person;
    }

    @Bean("bill")
    public Person bill() {
        Person person = new Person();
        person.setName("比尔盖茨");
        person.setAge(0);
        person.setGender("男");
        return person;
    }

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

    //使用@Primary指定默认的bean。
    //@Primary
    @Bean("lisi")
    public Person lisi() {
        Person person = new Person();
        person.setName("Cooper");
        person.setAge(0);
        person.setGender("男");
        return person;
    }
}
