package com.cao.pms.part1.dao;

import com.cao.pms.part1.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentDao {

    //查询所有部门
    List<Department> queryAllDepartment();

    //根据id查询部门
    int queryDepartmentById();
}
