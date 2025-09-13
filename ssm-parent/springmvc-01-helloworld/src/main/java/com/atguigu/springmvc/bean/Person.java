package com.atguigu.springmvc.bean;

import lombok.Data;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-12 11:43
 */
@Data
public class Person {
    private String username;
    private String password;
    private String cellphone;
    private boolean agreement;
    private Address address;
    private String sex;
    private String[] hobby;
    private String grade;
}

@Data
class Address {
    private String province;
    private String city;
    private String area;
}