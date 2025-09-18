package com.atguigu.restful.crud.dao.impl;

import com.atguigu.restful.crud.dao.EmpDao;
import com.atguigu.restful.crud.exception.BizException;
import com.atguigu.restful.crud.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 15:42
 */
@Repository
public class EmpDaoImpl implements EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Emp getEmpById(Long id) {
        String sql = "select * from employee where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), id);
    }

    @Override
    public int addEmp(Emp emp) {
        String sql = "insert into employee(name, age, email, gender, address, salary, birth) values(?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, emp.getName(), emp.getAge(), emp.getEmail(), emp.getGender(), emp.getAddress(), emp.getSalary(), emp.getBirth());
    }

    @Override
    public int updateEmp(Emp emp){
        String sql = "update employee set name = ?, age = ?, email = ?, gender = ?, address = ?, salary = ?, birth = ? where id = ?";
        int update =0;
        try {
            update = jdbcTemplate.update(sql, emp.getName(), emp.getAge(), emp.getEmail(), emp.getGender(), emp.getAddress(), emp.getSalary(), emp.getBirth(), emp.getId());
        } catch (DataAccessException e) {
            System.out.println("进入异常");
            throw new BizException("数据库更新失败: " + e.getMessage());
        }
        return update;
    }

    @Override
    public int deleteEmpById(Long id) {
        String sql = "delete from employee where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Emp> getList() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
    }
}
