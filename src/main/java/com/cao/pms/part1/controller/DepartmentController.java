package com.cao.pms.part1.controller;

import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.pojo.Parentdepartment;
import com.cao.pms.part1.service.Impl.DepartmentServiceImpl;
import com.cao.pms.part1.service.Impl.ParentdepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/department")
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private ParentdepartmentServiceImpl parentdepartmentService;

    //跳转到部门列表请求
    @RequestMapping("/toDlist")
    public String toDlist(Model model){
        List<Department> departments = departmentService.queryAllDepartmentExNull();
        //遍历所有部门，将人数查询出来放进去
        //遍历所有部门，将上级部门名查出来放进去
        for(Department department:departments){
            int numCount = departmentService.getNumCount(department.getDid());
            department.setEmpNums(numCount);

            Parentdepartment parName = departmentService.getParName(department.getParentdepart());
            department.setParentName(parName.getPdname());
        }

        model.addAttribute("departments",departments);

        return "/department/Dlist";
    }

    //跳转到修改部门页面
    @RequestMapping("/toDupdatePage{did}")
    public String toDupdate(@PathVariable("did") int did, Model model){
        Department Qdepartment = departmentService.queryDepartmentById(did);
        List<Parentdepartment> parentdepartments = parentdepartmentService.queryAllParentDepart();

        model.addAttribute("Qdepartment",Qdepartment);
        model.addAttribute("Pdepartments",parentdepartments);

        return "/department/DupdatePage";
    }

    //修改部门请求
    @PostMapping("/updateDepartment")
    public String updateDepartment(Department department){
        departmentService.updateDepartment(department);

        return "redirect:/department/toDlist";
    }

    //跳转添加页面请求
    @RequestMapping("/toAddDepartmentPage")
    public String toAddDepartmentPage(Model model){
        List<Parentdepartment> parentdepartments = parentdepartmentService.queryAllParentDepart();
        model.addAttribute("Pdepart",parentdepartments);

        return "department/DaddPage";
    }

    //添加部门请求
    @PostMapping("/addDepartment")
    public String addDepartment(@RequestParam("departmentName") String departmentName,
                                @RequestParam("parentdepart") Integer parentdepart,
                                @RequestParam("departinfo") String departinfo){
        departmentService.addDepartment(new Department(departmentName,parentdepart,departinfo));
        return "redirect:/department/toDlist";
    }

    //删除部门请求
    @RequestMapping("/deleteDepartment{did}")
    public String deleteDepartment(@PathVariable("did") int did){
        departmentService.deleteDepartment(did);
        return "redirect:/department/toDlist";
    }
}
