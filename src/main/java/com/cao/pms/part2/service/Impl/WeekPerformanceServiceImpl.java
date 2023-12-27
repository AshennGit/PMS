package com.cao.pms.part2.service.Impl;

import com.cao.pms.part2.dao.WeekPerformanceDao;
import com.cao.pms.part2.pojo.WeekPerformance;
import com.cao.pms.part2.service.WeekPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeekPerformanceServiceImpl implements WeekPerformanceService {

    @Autowired
    WeekPerformanceDao weekPerformanceDao;

    @Override
    public WeekPerformance queryWeekPerformance(int eid) {
        return weekPerformanceDao.queryWeekPerformance(eid);
    }
}
