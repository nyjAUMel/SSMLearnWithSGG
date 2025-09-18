package com.atguigu.restful.crud.vo.req;

import com.atguigu.restful.crud.annotation.GenderAnno;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 16:28
 */
@Data
public class EmpUpdateVo {
    /*
    Spring 的校验流程是：
        步骤一：数据绑定。Spring MVC 尝试将请求数据（比如 JSON）绑定到你的方法参数对象（EmpUpdateVo）上。
        步骤二：字段校验。如果数据绑定成功，Spring 才会对绑定的对象进行 @NotNull, @Email 等注解的校验。
     */
    @NotNull(message = "id不能为空")
    private Long id;
    private String name;
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
