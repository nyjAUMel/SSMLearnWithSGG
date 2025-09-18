package com.atguigu.restful.crud.vo.req;

import com.atguigu.restful.crud.annotation.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-17 15:21
 */
// 这是前端添加时用的Employee
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddVo {

    @NotEmpty(message = "名字不能为空")
    private String name;
    //@NotEmpty 用于检查字符串、集合等是否非空且有内容，不能检查Integer类型
    @NotNull
    @Max(value = 120, message = "年龄不能大于150")
    @Min(value = 0, message = "年龄不能小于0")
    private Integer age;
    @NotEmpty
    @Email
    private String email;
    @Gender(message = "{gender.message}")
    private String gender;
    private String address;
    private BigDecimal salary;
    /*
        默认的日期格式为：2025-09-17T15:21:05.000+00:00
        反序列化：前端发送的日期字符串 ---> 日期对象
        序列化：日期对象 ---> 日期字符串
     */
    // 该注解用来指定日期的格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
}
