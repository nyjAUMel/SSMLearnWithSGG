package com.atguigu.restful.crud.bean;


import com.atguigu.restful.crud.annotation.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee备用 {

    private Long id;
    // @NotNull 这个只是限制了不能为空，但是输入空格不管
    @NotEmpty(message = "名字不能为空") // 这个就限制了任何形式的空
    private String name;

    //@NotEmpty 用于检查字符串、集合等是否非空且有内容，不能检查Integer类型
    @NotNull
    @Max(value = 120, message = "年龄不能大于150")
    @Min(value = 0, message = "年龄不能小于0")
    private Integer age;

    @NotEmpty
    @Email
    private String email;
    // 中文网站性别展示：性别只能是男或者女
    //@Gender(message = "性别只能是男或者女")
    // 英文网站显示性别：Gender must be Male or Female
    // 采用国际化
    /*
    Spring Boot 中国际化消息默认从以下位置查找：
    application.properties 或 application.yml
    messages.properties 及其语言变体（如 messages_zh_CN.properties）
     */
    @Gender(message = "{gender.message}")
    private String gender;
    private String address;
    private BigDecimal salary;

}
