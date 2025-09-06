package com.atguigu.spring.ioc;

import com.atguigu.spring.ioc.bean.Dog;
import com.atguigu.spring.ioc.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/*
 * 这个是主入口类，称为主程序类
 * */
@SpringBootApplication
public class Spring001IocApplication {

    public static void main(String[] args) {
        // 1. 跑起一个Spring应用；    ApplicationContext：Spring应用上下文、IOC容器
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring001IocApplication.class, args);
        System.out.println(ioc);

        // 2. 获取容器中所有组件的名字； Spring启动会有很多默认组件
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("name = " + beanDefinitionName);
        }

        // 4. 获取容器中的组件对象；   精确获取某个组件
        // 组件的四大特性：名字、类型、对象、作用域
        // 组件名字全局唯一； 组件名重复了，一定只会给容器中放一个最先声明的那个。

        /*
        * 小结：
        *   从容器中获取组件：
        *           1、组件不存在，抛异常：NoSuchBeanDefinitionException
        *           2、（通过类型获取）组件不唯一，抛异常：NoUniqueBeanDefinitionException
        * */

        // 4.1 按照组件的名获取对象
        Person ppp = (Person) ioc.getBean("ppp");
        System.out.println(ppp);

        // 4.2 按照组件的类型获取对象
        /*Person bean = ioc.getBean(Person.class);
        System.out.println("按照组件的类型获取对象：" + bean);*/

        // 4.2 按照组件的类型获取该类型的所有对象
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println("按照组件的类型获取所有对象：" + beansOfType);


        //
    }

    // 3. 给容器注册一个自己的组件； 容器中的每个组件名都是方法名
    // 如果不想用方法名当组件名也可以给注解添加值，这个值就是组件名
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

    @Bean("dog")
    public Dog dog() {
        return new Dog();
    }

}
