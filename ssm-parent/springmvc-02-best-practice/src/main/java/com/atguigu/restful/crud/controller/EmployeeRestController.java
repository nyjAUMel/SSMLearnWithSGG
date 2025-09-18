package com.atguigu.restful.crud.controller;

import com.atguigu.restful.crud.bean.Employee;
import com.atguigu.restful.crud.common.R;
import com.atguigu.restful.crud.service.EmployeeService;
import com.atguigu.restful.crud.vo.req.EmployeeAddVo;
import com.atguigu.restful.crud.vo.req.EmployeeUpdateVo;
import com.atguigu.restful.crud.vo.resp.EmployeeRespVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-14 14:54
 */

/**
 * 数据校验：
 * 1. 导入校验包
 * 2. 编写校验注解
 * 3. 在参数处使用@Valid告诉SpringMVC进行校验
 * 效果1：如果校验不通过，目标方法不执行
 * 4. 在被@Valid修饰的参数后面紧跟一个 BindingResult参数，封装校验结果
 * 效果2：全局异常处理机制
 * 5. 【推荐】：编写一个全局异常处理器，处理MethodArgumentNotValidException（校验出错的异常），统一返回校验失败的提示信息
 * 6. 自定义校验 = 自定义校验注解 + 自定义验证器
 */
// @Tag注解描述该Controller类的作用
@Tag(name = "员工管理")
@CrossOrigin // 该注解也可以标在方法上，表示：只有该方法允许跨域访问
@RestController
// 在类上使用 @RequestMapping("/api/v1") 注解意味着：为该整个控制器类中的所有方法提供统一的URL前缀
@RequestMapping("/api/v1")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    /*
    @Parameters该注解用来生成Swagger时标明id的作用
    @Parameter用来制定具体的参数
    name要和参数里的名字一致
    description描述信息
    in = ParameterIn.PATH表示该参数在路径上
    required = true表示该参数是必须的
     */
    @Parameters({@Parameter(name = "id", description = "员工id", in = ParameterIn.PATH, required = true)})
    // @Operation用来描述方法作用
    @Operation(summary = "按照id查询员工")
    @GetMapping("/employee/{id}")
    public R get(@PathVariable
                 Long id) {
        System.out.println("查询");
        Employee employee = employeeService.getEmpById(id);
        System.out.println(employee);
        EmployeeRespVo vo = new EmployeeRespVo();
        BeanUtils.copyProperties(employee, vo);
        System.out.println(vo);
        return R.ok(vo);
    }

    /**
     * 删除员工
     * <p>
     * Spring MVC 还提供了其他 HTTP 方法的组合注解：
     *
     * @PostMapping - 处理 POST 请求
     * @PutMapping - 处理 PUT 请求
     * @DeleteMapping - 处理 DELETE 请求
     * @PatchMapping - 处理 PATCH 请求
     */
    @Operation(summary = "按照id删除员工信息")
    @DeleteMapping("/employee/{id}")
    public R delete(@PathVariable Long id) {
        employeeService.deleteEmpById(id);
        return R.ok();
    }

    /**
     * 添加员工
     * 要求：前端发送请求把员工的json放在请求体中
     * 要求：如果校验出错，返回给前端
     * {
     * "code": 500,
     * "msg": "校验失败",
     * "data": {
     * "name": "姓名不能为空", // 这些就是为了让前端知道是哪些输入框错了，怎么错误，给用户显示提示。
     * "age": "年龄不能超过150"
     * }
     * }
     */
    /* @PostMapping("/employee")
    public R add(@RequestBody @Valid Employee employee,
                  *//*
                 BindingResult 的作用
                    1. 收集验证错误：当使用 @Valid 注解进行数据校验时，验证结果（错误信息）会被自动收集到 BindingResult 对象中
                    2. 避免异常抛出：如果没有 BindingResult 参数，验证失败时会直接抛出异常；有了它，可以手动处理验证错误
                  *//*
                 BindingResult result) {

        // 校验通过
        if(!result.hasErrors()){
            System.out.println("新增用户方法执行");
            employeeService.addEmp(employee);
            return R.ok();
        }
        HashMap<String, String> errorMap = new HashMap<>();
        // 拿到所有属性错误的信息
        for (FieldError fieldError : result.getFieldErrors()) {
            // 拿到属性名
            String field = fieldError.getField();
            // 拿到错误信息
            String defaultMessage = fieldError.getDefaultMessage();
            errorMap.put(field, defaultMessage);
        }
        return R.error(500, "校验失败", errorMap);
    } */


    /**
     * 这个方法将上面的add里异常处理移到了全局异常处理当中
     * 全局异常处理MethodArgumentNotValidException.class处理这个异常
     *
     */
    @Operation(summary = "添加员工")
    @PostMapping("/employee")
    public R add(@RequestBody @Valid EmployeeAddVo vo) {

        Employee employee = new Employee();
        // 把VO（视图模型）转为DO（数据库模型）
        BeanUtils.copyProperties(vo, employee);

        System.out.println("新增用户方法执行");
        employeeService.addEmp(employee);
        return R.ok();
    }


    /**
     * 修改员工
     * 要求：前端发送请求把员工的json放在请求体中；必须携带id
     */
    @Operation(summary = "按照id修改员工信息")
    @PutMapping("/employee")
    public R update(@RequestBody @Valid EmployeeUpdateVo vo) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(vo, employee);
        System.out.println("修改用户方法执行");
        employeeService.updateEmp(employee);
        return R.ok();
    }

    @Operation(summary = "获取所有员工信息")
    @GetMapping("/employees")
    public R all() {
        List<Employee> employees = employeeService.getList();
        ArrayList<EmployeeRespVo> employeeRespVos = new ArrayList<>();

        // 目的：脱敏、分层
        for (Employee employee : employees) {
            EmployeeRespVo vo = new EmployeeRespVo();
            BeanUtils.copyProperties(employee, vo);
            employeeRespVos.add(vo);
        }


        return R.ok(employees);
    }


}
