package com.cao.pms.part1.controller;

import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part1.service.Impl.DepartmentServiceImpl;
import com.cao.pms.part1.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/emp")
@Controller
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    DepartmentServiceImpl departmentService;

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

    //跳转到添加员工页面的请求
    @GetMapping("/toAddPage")
    public String toAddPage(Model model){
        List<Department> departments = departmentService.queryAllDepartment();
        //返回给前端修改员工表中的部门下拉单
        model.addAttribute("departments",departments);
        return "/emp/addPage";
    }

    //跳转到修改员工页面的请求
    @GetMapping("/toUpdatePage{eid}")
    public String toUpdatePage(@PathVariable("eid") Integer eid ,Model model){
        List<Department> departments = departmentService.queryAllDepartment();
        Employee Qemployee = employeeService.queryEmployeeById(eid);
        //返回给前端修改员工表中的部门下拉单
        model.addAttribute("departments",departments);
        model.addAttribute("QEmployee",Qemployee);
        return "/emp/updatePage";
    }

    //添加员工请求
    @PostMapping("/addEmployee")
    public  String addEmployee(@RequestParam("lastName") String lastName,
                               @RequestParam("email")String email,
                               int gender,
                               @RequestParam("department") int department){

        employeeService.addEmployee(new Employee(lastName, email, gender, department));
        return "redirect:/emp/selectAll";
    }

    //修改员工请求
    @PostMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/emp/selectAll";
    }

    //删除员工请求
    @RequestMapping("/deleteEmployee{eid}")
    public String deleteEmployee(@PathVariable("eid") Integer eid){
        employeeService.deleteEmployee(eid);
        return "redirect:/emp/selectAll";
    }
}
