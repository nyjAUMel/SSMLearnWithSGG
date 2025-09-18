package com.atguigu.restful.crud.service.impl;


import com.atguigu.restful.crud.dao.EmpDao;
import com.atguigu.restful.crud.pojo.Emp;
import com.atguigu.restful.crud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 15:42
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public Emp getEmpById(Long id) {
        Emp emp = empDao.getEmpById(id);
        return emp;
    }

    @Override
    public int addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }

    @Override
    public int updateEmp(Emp employee) {
        System.out.println("修改用户方法执行");
        Long id = employee.getId();
        /* if (id == null) { // 页面没带id
            // 中断的业务，必须让上层及以上的链路知道中断原因，推荐抛出业务异常
            throw new BizException(BizExceptionEnum.ORDER_CLOSED);
        } */
        // ====== 以下用页面值覆盖默认值
        Emp employeeById = empDao.getEmpById(id);
        // 判断name有值（不是空串，不是空白字符，不是null）
        if (!StringUtils.hasText(employee.getName())) {
            employee.setName(employeeById.getName());
        }
        if (employee.getAge() == null) {
            employee.setAge(employeeById.getAge());
        }
        if (!StringUtils.hasText(employee.getEmail())) {
            employee.setEmail(employeeById.getEmail());
        }
        if (!StringUtils.hasText(employee.getGender())) {
            employee.setGender(employeeById.getGender());
        }
        if (!StringUtils.hasText(employee.getAddress())) {
            employee.setAddress(employeeById.getAddress());
        }
        if (employee.getSalary() == null) {
            employee.setSalary(employeeById.getSalary());
        }
        return empDao.updateEmp(employee);
    }

    @Override
    public int deleteEmpById(Long id) {
        return empDao.deleteEmpById(id);
    }

    @Override
    public List<Emp> getList() {
        return empDao.getList();
    }
}
