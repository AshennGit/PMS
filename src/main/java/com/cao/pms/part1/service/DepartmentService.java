package com.cao.pms.part1.service;

import com.cao.pms.part1.pojo.Department;

import java.util.List;

public interface DepartmentService {


    //查询所有部门
    List<Department> queryAllDepartment();

    //根据id查询部门
    Department queryDepartmentById(int did);
}
