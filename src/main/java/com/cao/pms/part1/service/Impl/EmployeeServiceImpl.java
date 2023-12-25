package com.cao.pms.part1.service.Impl;

import com.cao.pms.part1.dao.EmployeeDao;
import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> queryAllEmployee() {
        return employeeDao.queryAllEmployee();
    }

    @Override
    public Employee queryEmployeeById(int id) {
        return employeeDao.queryEmployeeById(id);
    }

    @Override
    public int addEmployee(Employee employee) {

        return employeeDao.addEmployee(employee);
    }

    @Override
    public int deleteEmployee(int eid) {
        return employeeDao.deleteEmployee(eid);
    }
}
