package com.cao.pms.part1.dao;

import com.cao.pms.part1.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentDao {

    //查询所有部门
    List<Department> queryAllDepartment();

    //根据id查询部门
    Department queryDepartmentById(@Param("did") int did);

    //根据id删除部门
    int deleteDepartment(@Param("did") int did);

    //添加部门
    int addDepartment(Department department);

    //修改部门
    int updateDepartment(Department department);
}
