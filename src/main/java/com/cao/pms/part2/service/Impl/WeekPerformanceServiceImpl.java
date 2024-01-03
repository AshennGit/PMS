package com.cao.pms.part2.service.Impl;

import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part1.service.Impl.EmployeeServiceImpl;
import com.cao.pms.part2.dao.WeekPerformanceDao;
import com.cao.pms.part2.pojo.WeekPerformance;
import com.cao.pms.part2.service.WeekPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeekPerformanceServiceImpl implements WeekPerformanceService {

    @Autowired
    private WeekPerformanceDao weekPerformanceDao;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Override
    public WeekPerformance queryWeekPerformance(int eid) {
        return weekPerformanceDao.queryWeekPerformance(eid);
    }

    //获取有绩效的员工
    //获取到考核表对应的员工姓名,再将员工姓名存到List的每个元素中
    public List<WeekPerformance> queryEmpPerformance(){
        List<Employee> employees = employeeService.queryAllEmployee();
        List<WeekPerformance> weekPerformanceList = new ArrayList<>();
        for(Employee employee:employees){
            WeekPerformance weekPerformance = weekPerformanceDao.queryWeekPerformance(employee.getEid());
            if(weekPerformance!=null){
                weekPerformance.setEName(employee.getLastName());
                weekPerformanceList.add(weekPerformance);
            }
        }
        return weekPerformanceList;
    }
}
