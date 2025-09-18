package com.atguigu.restful.crud.dao.impl;

import com.atguigu.restful.crud.bean.Employee;
import com.atguigu.restful.crud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-14 09:55
 */
@Component
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee getEmpById(Long id) {
        String sql = "select * from employee where id = ?";
        // 如果使用 jdbcTemplate.queryForObject() 查询不到数据，会直接抛出异常。
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
        return employee;
    }

    @Override
    public void addEmp(Employee employee) {
        String sql = "insert into employee(name, age, email, gender, address, salary, birthday) values(?, ?, ?, ?, ?, ?, ?)";
        int update = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getBirth());
        System.out.println("新增影响行数：" + update);
    }

    @Override
    public void updateEmp(Employee employee) {
        String sql = "update employee set name = ?, age = ?, email = ?, gender = ?, address = ?, salary = ? where id = ?";
        int update = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getId());
        System.out.println("修改影响行数：" + update);
    }

    @Override
    public void deleteEmpById(Long id) {
        String sql = "delete from employee where id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("删除影响行数：" + update);
    }

    @Override
    public List<Employee> getList(){
        String sql = "select * from employee";
        List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return employees;
    }
}
