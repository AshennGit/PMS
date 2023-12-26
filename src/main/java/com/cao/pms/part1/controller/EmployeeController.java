package com.cao.pms.part1.controller;

import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part1.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/emp")
@Controller
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    //查询所有员工的请求
    @RequestMapping("/selectAll")
    public String List(Model model){
        List<Employee> employees = employeeService.queryAllEmployee();
        for (Employee employee:employees){
            employee.setDepartmentName(employeeService.getDepartmentName(employee.getDepartment()));
        }
        model.addAttribute("emps",employees);
        return "/emp/Elist";
    }
}
