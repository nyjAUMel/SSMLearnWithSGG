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
 * @Create: 2025-09-18 16:05
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpRespVo {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private BigDecimal salary;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
}
