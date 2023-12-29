package com.cao.pms.part1.service;

import com.cao.pms.part1.pojo.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> queryAllEmployee();

    //根据id查询员工
    Employee queryEmployeeById(int eid);

    //添加员工
    int addEmployee(Employee employee);

    //根据id删除员工
    int deleteEmployee(int eid);

    //修改员工信息
    int updateEmployee(Employee employee);

    int updateEmployeeDepart(int eid, int department);
}
