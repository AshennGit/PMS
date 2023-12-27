package com.cao.pms.part1.dao;

import com.cao.pms.part1.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeDao {
    //查询所有员工
    List<Employee> queryAllEmployee();

    //根据id查询员工
    Employee queryEmployeeById(@Param("eid") int eid);

    //添加员工
    int addEmployee(Employee employee);

    //根据id删除员工
    int deleteEmployee(int eid);

    //修改员工信息
    int updateEmployee(Employee employee);
}
