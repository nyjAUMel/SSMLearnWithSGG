package com.atguigu.restful.crud.dao;

import com.atguigu.restful.crud.bean.Employee;

import java.util.List;

/**
 * 无限进步!!!
 * Description:
 *
 * @Author AU
 * @Create: 2025-09-14 09:54
 * @Version: 1.0
 */
public interface EmployeeDao {

    /**
     * 根据员工id查询员工
     * @param id
     * @return
     */
    Employee getEmpById(Long id);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    void addEmp(Employee employee);

    /**
     * 修改员工
     * @param employee
     * @return
     */
    void updateEmp(Employee employee);

    /**
     * 删除员工
     * @param id
     * @return
     */
    void deleteEmpById(Long id);

    /**
     * 查询所有员工
     * @return
     */
    List<Employee> getList();
}
