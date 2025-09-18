package com.atguigu.restful.crud.vo.req;

import com.atguigu.restful.crud.annotation.GenderAnno;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 16:05
 */
@Data
public class EmpAddVo {
    @NotEmpty(message = "名字不能为空")
    private String name;
    @NotNull
    @Max(value = 150, message = "年龄不能大于150")
    @Min(value = 0, message = "年龄不能小于0")
    private Integer age;
    @Email
    private String email;
    @GenderAnno(message = "{gender.message}")
    private String gender;
    private String address;
    private BigDecimal salary;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
}
