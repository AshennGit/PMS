package com.cao.pms.part1.service.Impl;

import com.cao.pms.part1.dao.ParentdepartmentDao;
import com.cao.pms.part1.pojo.Parentdepartment;
import com.cao.pms.part1.service.ParentdepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentdepartmentServiceImpl implements ParentdepartmentService {

    @Autowired
    private ParentdepartmentDao parentdepartmentDao;

    @Override
    public Parentdepartment queryParentDepartmentById(int pdid) {
        return parentdepartmentDao.queryParentDepartmentById(pdid);
    }

    @Override
    public List<Parentdepartment> queryAllParentDepart() {
        return parentdepartmentDao.queryAllParentDepart();
    }
}
