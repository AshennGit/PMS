package com.cao.pms.part1.service.Impl;

import com.cao.pms.part1.dao.DepartmentDao;
import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part1.pojo.Parentdepartment;
import com.cao.pms.part1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private ParentdepartmentServiceImpl parentdepartmentService;

    @Override
    public List<Department> queryAllDepartment() {
        return departmentDao.queryAllDepartment();
    }

    @Override
    public Department queryDepartmentById(int did) {
        return departmentDao.queryDepartmentById(did);
    }

    @Override
    public int deleteDepartment(int did) {
        return departmentDao.deleteDepartment(did);
    }

    @Override
    public int addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    //查询所有部门但是排除部门表中的暂无部门
    public List<Department> queryAllDepartmentExNull() {
        List<Department> allDepartExNull = new ArrayList<>();
        List<Department> allDepartment = departmentDao.queryAllDepartment();
        for (Department department:allDepartment){
            if(department.getDid()!=100){
                allDepartExNull.add(department);
            }
        }
        return allDepartExNull;
    }

    //统计人数服务
    public int getNumCount(int did){
        int count=0;
        List<Employee> employees = employeeService.queryAllEmployee();
        for(Employee employee:employees){
            if(employee.getDepartment()==did){
                count++;
            }
        }
        return count;
    }

    //获取上级部门服务
    public Parentdepartment getParName(int pdid){
        return parentdepartmentService.queryParentDepartmentById(pdid);
    }
}
