package com.atguigu.spring.ioc.bean;

import lombok.Data;

/**
 * Description:
 *
 * @Author: nyjAUMel
 * @CreationDate: 2025/9/5 23:05
 */
@Data
public class Person {
    private String name;
    private int age;
    private String gender;

    public Person() {
        System.out.println("Person无参构造方法");
    }
}
