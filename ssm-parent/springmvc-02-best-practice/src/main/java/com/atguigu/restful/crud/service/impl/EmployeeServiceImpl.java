package com.atguigu.restful.crud.service.impl;

import com.atguigu.restful.crud.bean.Employee;
import com.atguigu.restful.crud.dao.EmployeeDao;
import com.atguigu.restful.crud.exception.BizException;
import com.atguigu.restful.crud.exception.BizExceptionEnum;
import com.atguigu.restful.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-14 10:38
 */
@Component // 规定：Controller调Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public Employee getEmpById(Long id) {
        Employee employee = employeeDao.getEmpById(id);
        return employee;
    }

    @Override
    public void addEmp(Employee employee) {
        employeeDao.addEmp(employee);
    }

    @Override
    public void updateEmp(Employee employee) {

        Long id = employee.getId();
        if (id == null) { // 页面没带id
            // 中断的业务，必须让上层及以上的链路知道中断原因，推荐抛出业务异常
            throw new BizException(BizExceptionEnum.ORDER_CLOSED);
        }
        // ====== 以下用页面值覆盖默认值
        Employee employeeById = employeeDao.getEmpById(id);
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
        employeeDao.updateEmp(employee);
    }

    @Override
    public void deleteEmpById(Long id) {
        employeeDao.deleteEmpById(id);
    }

    @Override
    public List<Employee> getList() {
        List<Employee> list = employeeDao.getList();
        return list;
    }
}
