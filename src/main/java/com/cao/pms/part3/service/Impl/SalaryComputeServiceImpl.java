package com.cao.pms.part3.service.Impl;

import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part1.service.Impl.DepartmentServiceImpl;
import com.cao.pms.part1.service.Impl.EmployeeServiceImpl;
import com.cao.pms.part2.pojo.WeekPerformance;
import com.cao.pms.part2.service.Impl.WeekPerformanceServiceImpl;
import com.cao.pms.part3.pojo.SalaryCompute;
import com.cao.pms.part3.pojo.Work;
import com.cao.pms.part3.service.SalaryComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryComputeServiceImpl implements SalaryComputeService {

    @Autowired
    private WeekPerformanceServiceImpl performanceService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private WorkServiceImpl workService;

    @Override
    public float computeDayperformence(int eid) {
        float dayPerformence;
        WeekPerformance weekPerformance = performanceService.queryWeekPerformance(eid);
        dayPerformence= (float) ((weekPerformance.getMon()+ weekPerformance.getTue()+weekPerformance.getWed()+
                        weekPerformance.getThu()+weekPerformance.getFri()+weekPerformance.getSat()+
                        weekPerformance.getSun())/(7.0));
        return dayPerformence;
    }

    //计算月薪
    @Override
    public float computeSuggestSalary(int eid, float coefficient) {
        float dayPerformance = computeDayperformence(eid);
        Work work = workService.getWorkDay(1);
        int workday = work.getWorkday();
        return dayPerformance*workday*coefficient;
    }


    //获取正式员工薪资表服务
    public List<SalaryCompute> getEmpSalaryList(){
        //获取有绩效的员工
        List<WeekPerformance> weekPerformanceList = performanceService.queryEmpPerformance();
        List<SalaryCompute> empSalaryList = new ArrayList<>();
        for(WeekPerformance weekPerformance:weekPerformanceList){
            SalaryCompute salary = new SalaryCompute();
            int eid = weekPerformance.getEid();
            String eName = weekPerformance.getEName();

            //通过eid获取员工，通过员工获取部门，通过部门获取部门薪资系数，通过部门系数计算建议薪资
            float dayperformence = computeDayperformence(eid);
            Employee employee = employeeService.queryEmployeeById(eid);
            Department department = departmentService.queryDepartmentById(employee.getDepartment());

            //保留两位小数
            float suggestSalary = computeSuggestSalary(eid, department.getDepartSalaryCoe());
            BigDecimal a = new BigDecimal(dayperformence);
            BigDecimal b = new BigDecimal(suggestSalary);
            float formatDayperformance = a.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
            float formatSuggestSalary = b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();

            //赋值
            salary.setEid(eid);
            salary.setEname(eName);
            salary.setDepartName(department.getDepartmentName());
            salary.setDayPerformence(formatDayperformance);
            salary.setSuggestSalary(formatSuggestSalary);
            empSalaryList.add(salary);
        }
        return  empSalaryList;
    }

}
