package com.atguigu.restful.crud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 15:43
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
    private Date birth;
}
