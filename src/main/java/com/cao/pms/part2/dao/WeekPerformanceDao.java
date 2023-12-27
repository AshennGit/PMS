package com.cao.pms.part2.dao;

import com.cao.pms.part2.pojo.WeekPerformance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//绩效考核
@Mapper
@Repository
public interface WeekPerformanceDao {
    WeekPerformance queryWeekPerformance(int eid);
}
