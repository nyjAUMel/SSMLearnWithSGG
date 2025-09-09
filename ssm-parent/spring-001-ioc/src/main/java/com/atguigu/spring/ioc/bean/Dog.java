package com.atguigu.spring.ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


/**
 * Description:
 *
 * @Author: nyjAUMel
 * @CreationDate: 2025/9/6 12:03
 */
@Data

public class Dog {

    // Spring获取bean的属性默认为空值
    /*
    @Value用来添加默认值
        1. @Value("旺财")：字面量值
        2. @Value("${}")：动态从配置文件取出其中某一项取出
        3. @Value("#{SpEL}")：Spring Expression Language：Spring表达式语言
     */
    @Value("旺财")
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
