package com.cao.pms.part2.controller;

import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part1.service.Impl.EmployeeServiceImpl;
import com.cao.pms.part2.pojo.WeekPerformance;
import com.cao.pms.part2.service.Impl.WeekPerformanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//绩效考核相关
@RequestMapping("/appraisal")
@Controller
public class PerformanceController {

    @Autowired
    WeekPerformanceServiceImpl weekPerformanceService;

    @Autowired
    EmployeeServiceImpl employeeService;

    //跳转到考核List
    @RequestMapping("/toPlist")
    public String toPlist(Model model){

        List<WeekPerformance> weekPerformanceList = weekPerformanceService.queryEmpPerformance();

        model.addAttribute("WeekList",weekPerformanceList);

        return "performance/Plist";
    }

    //展示数据
    @GetMapping("/showdata{eid}")
    public String showData(@PathVariable("eid") Integer eid, Model model){

        WeekPerformance weekPerformance = weekPerformanceService.queryWeekPerformance(eid);
        Employee employee = employeeService.queryEmployeeById(eid);
        model.addAttribute("data",weekPerformance);
        model.addAttribute("employee",employee);

        return "/performance/data";
    }
}
