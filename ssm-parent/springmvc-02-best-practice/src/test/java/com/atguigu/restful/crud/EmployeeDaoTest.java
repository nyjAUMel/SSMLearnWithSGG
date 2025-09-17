package com.atguigu.restful.crud;

import com.atguigu.restful.crud.bean.Employee;
import com.atguigu.restful.crud.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-14 10:44
 */
@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void testEmployeeDao() {
        Employee empById = employeeDao.getEmpById(4L);
        System.out.println("查到的员工：" + empById);


        /* Employee employee = new Employee(null, "王麻子", 22, "123@qq.com", "男", "上海", new BigDecimal(10000));
        employeeDao.addEmp(employee); */

        /* Employee updateEmp = new Employee(5L, "王小虎", 33, "123@outlook.com", "男", "北京", new BigDecimal(100));
        employeeDao.updateEmp(updateEmp); */

        employeeDao.deleteEmpById(5L);
    }
}
