package com.atguigu.restful.crud.controller;

import com.atguigu.restful.crud.common.R;
import com.atguigu.restful.crud.pojo.Emp;
import com.atguigu.restful.crud.service.EmpService;
import com.atguigu.restful.crud.vo.req.EmpAddVo;
import com.atguigu.restful.crud.vo.req.EmpUpdateVo;
import com.atguigu.restful.crud.vo.resp.EmpRespVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 15:35
 */
@RestController
public class EmpRestController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emp/{id}")
    public R getEmp(@PathVariable Long id) {
        Emp emp = empService.getEmpById(id);
        EmpRespVo vo = new EmpRespVo();
        BeanUtils.copyProperties(emp, vo);
        return R.success(vo);
    }



    @PostMapping("/emp")
    public R addEmp(@RequestBody
    /*
    一旦校验失败抛出异常，就不会执行 updateEmp 方法中的业务逻辑代码，会被全局异常捕获
    全局异常处理器的返回值就是最终返回给客户端的响应
     */
                    @Valid EmpAddVo vo) {
        Emp emp = new Emp();
        BeanUtils.copyProperties(vo, emp);
        System.out.println("添加用户方法执行");
        int i = empService.addEmp(emp);
        return i > 0 ? R.success() : R.error();
    }

    @PutMapping("/emp")
    public R updateEmp(@RequestBody
                       @Valid EmpUpdateVo vo) {
        Emp emp = new Emp();
        System.out.println(vo);
        BeanUtils.copyProperties(vo, emp);
        System.out.println(emp);
        System.out.println("修改用户方法执行");
        int i = empService.updateEmp(emp);
        return i > 0 ? R.success() : R.error();
    }

    @DeleteMapping("/emp/{id}")
    public R deleteEmp(@PathVariable Long id) {
        System.out.println("删除用户方法执行");
        int i = empService.deleteEmpById(id);
        return i > 0 ? R.success() : R.error();
    }
}
