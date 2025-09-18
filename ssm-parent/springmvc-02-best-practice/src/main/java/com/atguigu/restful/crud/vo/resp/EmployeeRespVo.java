package com.atguigu.restful.crud.vo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-17 15:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRespVo {
    private Long id;
    private String name;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
    // 用来控制 Java 对象在序列化（转 JSON）和反序列化（从 JSON 转回）时的日期/时间格式、时区等行为
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
}
