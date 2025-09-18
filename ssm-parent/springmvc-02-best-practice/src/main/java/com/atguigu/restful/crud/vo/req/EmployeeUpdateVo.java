package com.atguigu.restful.crud.vo.req;

import com.atguigu.restful.crud.annotation.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
// @Schema 用于生成Swagger文档时提示前端人员要提交的数据
@Schema(description = "员工修改需要提交的数据")
public class EmployeeUpdateVo {

    @Schema(description = "员工id")
    @NotNull(message = "id不能为空")
    private Long id;
    @Schema(description = "员工姓名")
    private String name;
    @NotNull
    @Max(value = 120, message = "年龄不能大于150")
    @Min(value = 0, message = "年龄不能小于0")
    @Schema(description = "员工年龄")
    private Integer age;
    @Email
    @Schema(description = "员工邮箱")
    private String email;
    @Schema(description = "员工性别")
    private String gender;
    @Schema(description = "员工地址")
    private String address;
    @Schema(description = "员工薪资")
    private BigDecimal salary;

}
