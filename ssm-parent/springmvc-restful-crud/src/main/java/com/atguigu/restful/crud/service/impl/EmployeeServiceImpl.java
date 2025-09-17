package com.atguigu.restful.crud.service.impl;

import com.atguigu.restful.crud.bean.Employee;
import com.atguigu.restful.crud.dao.EmployeeDao;
import com.atguigu.restful.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
        /*
        防null处理，controller调用service，传过来的某些属性可能为null，所以先处理
        处理方式：
            先查询employee原来的值，然后用controller传来的值覆盖掉原来的值
         */
        Long id = employee.getId();
        if(id == null) { // 页面没带id
            return;
        }
        // ====== 以下用页面值覆盖默认值
        Employee employeeById = employeeDao.getEmpById(id);
        // 判断name有值（不是空串，不是空白字符，不是null）
        if(!StringUtils.hasText(employee.getName())) {
            employee.setName(employeeById.getName());
        }
        if(employee.getAge() == null) {
            employee.setAge(employeeById.getAge());
        }
        if(!StringUtils.hasText(employee.getEmail())) {
            employee.setEmail(employeeById.getEmail());
        }
        if(!StringUtils.hasText(employee.getGender())) {
            employee.setGender(employeeById.getGender());
        }
        if(!StringUtils.hasText(employee.getAddress())) {
            employee.setAddress(employeeById.getAddress());
        }
        if(employee.getSalary() == null) {
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
