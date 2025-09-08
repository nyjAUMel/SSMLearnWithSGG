package com.atguigu.spring.ioc;

import ch.qos.logback.core.CoreConstants;
import com.atguigu.spring.ioc.bean.Car;
import com.atguigu.spring.ioc.bean.Dog;
import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.controller.UserController;
import com.atguigu.spring.ioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;
import java.util.Scanner;

/*
 * 这个是主入口类，称为主程序类
 * */
@SpringBootApplication
public class Spring001IocApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring001IocApplication.class, args);
        System.out.println("====================ioc容器创建完成================");

        // 拿到环境变量
        ConfigurableEnvironment environment = ioc.getEnvironment();
        String os = environment.getProperty("OS");
        System.out.println(os);

        Dog dog = ioc.getBean("dog", Dog.class);
        System.out.println(dog);
    }


    // FactoryBean在容器中放的组件类型，是接口中范型指定的类型。组件名是工厂子的名字(BYDFactory)
    public static void test05(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring001IocApplication.class, args);
        System.out.println("====================ioc容器创建完成================");

        Map<String, Car> beans = ioc.getBeansOfType(Car.class);
        System.out.println(beans);
    }


    /*
    * 默认：分层注解能起作用的前提是，这些组件必须在主程序所在的包及其子包结构下
    *   @ComponentScan()这个注解用来扫描参数包下的注解
    * Spring提供了快速的MVC分层注解
    *   1、@Controller 控制器
    *   2、@Service 服务层
    *   3、@Repository 持久层
    *   4、@Component 组件
    *  */
    public static void test04(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring001IocApplication.class, args);
        UserController uc = ioc.getBean(UserController.class);
        System.out.println(uc);

        UserService us = ioc.getBean(UserService.class);
        System.out.println(us);

        /* Dog d1 = ioc.getBean(Dog.class);
        Dog d2 = ioc.getBean(Dog.class);

        System.out.println(d1); */

    }


    /*
    * 组件：框架的底层配置
    *   配置文件：指定位置
    *   配置类：分类管理组件的配置，配置累也是容器中的一种组件，这种组件用来集中管理普通的Bean
    * Bean的创建时机：容器启动过程中就会创建组件对象。
    * 单实例特性：所有组件默认是单例的。每次获取容器直接从容器中拿。容器提前会创建组件
    *  */
    public static void test02(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring001IocApplication.class);
        System.out.println("容器执行完成-------");
        Person p1 = ioc.getBean("ppp",Person.class);
        Person p2 = ioc.getBean("ppp",Person.class);
        System.out.println(p1 == p2);
    }

    public static void test01BeanAnnotation(String[] args) {
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

        // 4.3 按照组件的类型获取该类型的所有对象
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println("按照组件的类型获取所有对象：" + beansOfType);


        // 4.4 按照类型 + 名字
        Person beanByNameAndType = ioc.getBean("ppp", Person.class);
        System.out.println(beanByNameAndType);
    }

    // 3. 给容器注册一个自己的组件； 容器中的每个组件名都是方法名
    // 如果不想用方法名当组件名也可以给注解添加值，这个值就是组件名




}
