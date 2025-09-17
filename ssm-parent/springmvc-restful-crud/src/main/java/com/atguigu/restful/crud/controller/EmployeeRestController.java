package com.atguigu.restful.crud.controller;

import com.atguigu.restful.crud.bean.Employee;
import com.atguigu.restful.crud.common.R;
import com.atguigu.restful.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-14 14:54
 */
/*
    跨域问题：
        1. 前端自己解决
        2. 后段解决：允许前端跨域即可
            采用注解：
                原理：服务器给浏览器的响应添加一个响应头 Access-Control-Allow-Origin = *
            过程：
                对于简单请求（简单请求的定义有三条，去AI查）
                    1. 浏览器直接发送请求，后端返回：
                        HTTP/1.1 200 OK
                        Access-Control-Allow-Origin: http://localhost:3000
                        Content-Type: application/json

                        {"id":1,"name":"张三"}
                    2. 浏览器看到 Access-Control-Allow-Origin 匹配，就允许前端读取数据。
                对于复杂请求：只要不满足上面任一条件，就是复杂请求，会触发 预检（Preflight）
                    1. 浏览器会先发一个 OPTIONS 请求（预检）
                        这个请求不带真实数据，但在返回头中包含一条Access-Control-Allow-Origin: *
                    2. 浏览器发送第2次请求：真实请求（只有预检通过才发）
 */
@CrossOrigin // 该注解也可以标在方法上，表示：只有改方法允许跨域访问
@RestController
// 在类上使用 @RequestMapping("/api/v1") 注解意味着：为该整个控制器类中的所有方法提供统一的URL前缀
@RequestMapping("/api/v1")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    /*
    返回给前端不同的数据类型对于前端来说有些麻烦，通常这样解决：
        返回给前端以下数据：
            {
                "code": 200,
                "msg": "操作成功",
                "data": {
                    id: 1,
                    name: "张三",
                    age: 18
                }
            }
        code: 200 表示操作成功，剩下的都是失效
        msg: 返回给前端的提示信息
        data: 返回给前端的数据

    前端统一处理：
        1. 前端发送请求，接受服务器数据
        2. 判断状态码，如果成功，就显示数据，如果失败，则显示提示信息
     */


    /**
     * {}表示：路径是动态的
     * 访问路径：/employee/1
     *
     * @GetMapping 是 @RequestMapping(method = RequestMethod.GET) 的简写形式
     * 专门用于处理 HTTP GET 请求
     * @PathVariable和@RequestParam不一样 PathVariable：从路径中获取参数
     * RequestParam：从请求中获取参数，也就是get请求的问号后面，post请求的body
     */

    @GetMapping("/employee/{id}")
    public R get(@PathVariable Long id) {

        Employee employee = employeeService.getEmpById(id);

        return R.ok(employee);
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
    @DeleteMapping("/employee/{id}")
    public R delete(@PathVariable Long id) {
        employeeService.deleteEmpById(id);
        return R.ok();
    }

    /**
     * 添加员工
     */
    @PostMapping("/employee")
    public R add(@RequestBody Employee employee) {
        employeeService.addEmp(employee);
        return R.ok();
    }

    /**
     * 修改员工
     * 要求：前端发送请求把员工的json放在请求体中；必须携带id
     */
    @PutMapping("/employee")
    public R update(@RequestBody Employee employee) {
        employeeService.updateEmp(employee);
        return R.ok();
    }

    @GetMapping("/employees")
    public R all() {
        List<Employee> employees = employeeService.getList();
        return R.ok(employees);
    }


}
