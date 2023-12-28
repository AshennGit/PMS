package com.cao.pms.part1.service;

import com.cao.pms.part1.pojo.Parentdepartment;

import java.util.List;


public interface ParentdepartmentService {
    //根据pdid查询上级部门
    Parentdepartment queryParentDepartmentById(int pdid);

    //查询所有上级bum
    List<Parentdepartment> queryAllParentDepart();
}
