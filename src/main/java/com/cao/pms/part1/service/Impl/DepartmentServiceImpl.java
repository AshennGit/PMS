package com.cao.pms.part1.service.Impl;

import com.cao.pms.part1.dao.DepartmentDao;
import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> queryAllDepartment() {
        return departmentDao.queryAllDepartment();
    }

    @Override
    public Department queryDepartmentById(int did) {
        return departmentDao.queryDepartmentById(did);
    }
}
