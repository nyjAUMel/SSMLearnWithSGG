package com.atguigu.spring.ioc.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * Description:
 *
 * @Author: nyjAUMel
 * @CreationDate: 2025/9/6 12:03
 */
// @PropertySource 注解必须写在“会被 Spring 容器主动处理的类”上，否则它根本不会被解析！
@PropertySource("classpath:dog.properties")
@Component
@Data
@ToString
public class Dog {

    // Spring获取bean的属性默认为空值
    /*
    @Value用来添加默认值
        1. @Value("旺财")：字面量值
        2. @Value("${}")：动态从配置文件取出其中某一项取出
        3. @Value("#{SpEL}")：Spring Expression Language：Spring表达式语言

    补充：Spring 的依赖注入（DI）和 @Value 赋值，只对 被 Spring 管理的 Bean 有效！
        所以要想生效得让Spring管理Bean，而一个类要成为 Spring Bean，必须满足两个条件：
            1. 被 Spring 扫描到（比如加了 @Component、@Service 等）
            2. 被加载到 Spring 容器中
     */
    @Value("${dog.name}")
    private String name;
    @Value("${dog.age}")
    private Integer age;
    @Value("#{10*20}")
    private String color;
    // T()表示调用静态类
    @Value("#{T(java.util.UUID).randomUUID().toString()}")
    private String id;
    @Value("#{'Hello World'.substring(0,5)}")
    private String msg;
    @Value("#{1>2?'Japan':'Korea'}")
    private String country;
    @Value("#{new int[]{1,2,3}}")
    private int[] arr;

    public Dog() {
        System.out.println("Dog构造器执行");
    }
}
