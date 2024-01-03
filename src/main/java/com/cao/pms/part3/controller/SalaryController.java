package com.cao.pms.part3.controller;

import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.service.Impl.DepartmentServiceImpl;
import com.cao.pms.part1.service.Impl.EmployeeServiceImpl;
import com.cao.pms.part2.pojo.Exercitation;
import com.cao.pms.part2.pojo.WeekPerformance;
import com.cao.pms.part2.service.Impl.ExercitationServiceImpl;
import com.cao.pms.part2.service.Impl.WeekPerformanceServiceImpl;
import com.cao.pms.part3.pojo.SalaryCompute;
import com.cao.pms.part3.pojo.Work;
import com.cao.pms.part3.service.Impl.SalaryComputeServiceImpl;
import com.cao.pms.part3.service.Impl.WorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/salary")
@Controller
public class SalaryController {

    @Autowired
    private SalaryComputeServiceImpl salaryComputeService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private ExercitationServiceImpl exercitationService;

    @Autowired
    private WorkServiceImpl workService;

    //跳转到正式员工的薪资页面
    @RequestMapping("/empSalaryList")
    public String toEmpSalaryList(Model model){
        //调用获取有绩效的员工的薪资表服务
        List<SalaryCompute> empSalaryList = salaryComputeService.getEmpSalaryList();

        Work workDay = workService.getWorkDay(1);

        model.addAttribute("empSalaryList",empSalaryList);
        model.addAttribute("workday",workDay);

        return "/salary/EmpSalary";
    }

    //跳转到部门薪资系数页面
    @RequestMapping("/toCoeList")
    public String toCoeList(Model model){

        List<Department> allDepartment = departmentService.queryAllDepartment();
        model.addAttribute("allDepartment",allDepartment);

        return "/salary/Coelist";
    }

    //修改部门薪资系数
    @RequestMapping("/updateCoe")
    public String updateCoe(@RequestParam("did") Integer did, @RequestParam("departSalaryCoe") float coe){
        departmentService.updateDepartSalaryCoe(did,coe);
        return"redirect:/salary/toCoeList";
    }

    //跳转到实习生的薪资页面
    @RequestMapping("/exempSalaryList")
    public String toExempSalaryList(Model model){
        List<Exercitation> exercitations = exercitationService.queryAllExercitation();
        Work workDay = workService.getWorkDay(1);

        model.addAttribute("exercitations",exercitations);
        model.addAttribute("workday",workDay);
        return "/salary/ExempSalary";
    }

    //修改实习生日薪请求
    @RequestMapping("/updateExempSalary")
    public String updateExempSalary(@RequestParam("exid") int exid, @RequestParam("salary") int salary){
        exercitationService.updateExerSalary(exid,salary);
        return "redirect:/salary/exempSalaryList";
    }

    //修改工作日天数请求
    @RequestMapping("/updateWorkDay")
    public String updateWorkDay( @RequestParam("wid") int wid ,@RequestParam("workday") int workday){
        workService.updateWorkDay(wid,workday);
        return "redirect:/salary/empSalaryList";
    }
}
