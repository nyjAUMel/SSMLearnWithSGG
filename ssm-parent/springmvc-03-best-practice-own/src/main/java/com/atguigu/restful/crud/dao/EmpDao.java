package com.atguigu.restful.crud.dao;

import com.atguigu.restful.crud.pojo.Emp;

import java.sql.SQLException;
import java.util.List;

/**
 * 无限进步!!!
 * Description:
 *
 * @Author AU
 * @Create: 2025-09-18 15:42
 * @Version: 1.0
 */
public interface EmpDao {

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Emp getEmpById(Long id);

    /**
     * 添加员工
     * @param emp
     */
    int addEmp(Emp emp);

    /**
     * 修改员工
     * @param emp
     */
    int updateEmp(Emp emp);

    /**
     * 删除员工
     * @param id
     */
    int deleteEmpById(Long id);

    /**
     * 查询所有员工
     * @return
     */
    List<Emp> getList();
}
