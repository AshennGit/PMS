package com.cao.pms.part3.service;


import com.cao.pms.part3.pojo.Work;
import org.apache.ibatis.annotations.Param;

public interface WorkService {
    int updateWorkDay(int wid, int workday);

    Work getWorkDay(int wid);
}
