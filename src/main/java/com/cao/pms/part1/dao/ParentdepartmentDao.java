package com.cao.pms.part1.dao;

import com.cao.pms.part1.pojo.Parentdepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ParentdepartmentDao {
    //根据pdid查询上级部门
    Parentdepartment queryParentDepartmentById(@Param("pdid") int pdid);

    //查询所有上级部门
    List<Parentdepartment> queryAllParentDepart();

}
