package com.cao.pms.part3.dao;

import com.cao.pms.part3.pojo.Work;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WorkDao {
    int updateWorkDay(@Param("wid") int wid, @Param("workday") int workday);

    Work getWorkDay(@Param("wid") int wid);
}
