package com.cao.pms.part1.service;

import com.cao.pms.part1.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {


    //查询所有部门
    List<Department> queryAllDepartment();

    //根据id查询部门
    Department queryDepartmentById(int did);

    //根据id删除部门
    int deleteDepartment(int did);

    //添加部门
    int addDepartment(Department department);

    //修改部门
    int updateDepartment(Department department);

    //修改部门薪资系数
    int updateDepartSalaryCoe(int did, float salaryCoe);
}
