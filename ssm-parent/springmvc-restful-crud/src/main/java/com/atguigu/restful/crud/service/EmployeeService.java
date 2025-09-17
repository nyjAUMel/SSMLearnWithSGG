package com.atguigu.restful.crud.service;

import com.atguigu.restful.crud.bean.Employee;

import java.util.List;

/**
 * 无限进步!!!
 * Description:
 *
 * @Author AU
 * @Create: 2025-09-14 10:37
 * @Version: 1.0
 */
public interface EmployeeService {

    /**
     * 获取员工信息
     * @param id
     * @return
     */
    Employee getEmpById(Long id);

    /**
     * 添加员工信息
     * @param employee
     */
    void addEmp(Employee employee);

    /**
     * 修改员工信息
     * @param employee
     */
    void updateEmp(Employee employee);

    /**
     * 删除员工信息
     * @param id
     */
    void deleteEmpById(Long id);

    /**
     * 获取员工列表
     * @return
     */
    List<Employee> getList();
}
