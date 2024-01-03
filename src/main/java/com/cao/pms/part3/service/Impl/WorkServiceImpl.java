package com.cao.pms.part3.service.Impl;

import com.cao.pms.part3.dao.WorkDao;
import com.cao.pms.part3.pojo.Work;
import com.cao.pms.part3.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkDao workDao;

    //修改本月工作日
    @Override
    public int updateWorkDay(int wid, int workday) {
        return workDao.updateWorkDay(wid,workday);
    }

    @Override
    public Work getWorkDay(int wid) {
        return workDao.getWorkDay(wid);
    }
}
