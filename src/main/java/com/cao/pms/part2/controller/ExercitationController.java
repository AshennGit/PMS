package com.cao.pms.part2.controller;

import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part1.service.Impl.DepartmentServiceImpl;
import com.cao.pms.part1.service.Impl.EmployeeServiceImpl;
import com.cao.pms.part2.pojo.Exercitation;
import com.cao.pms.part2.service.Impl.ExercitationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/exemp")
@Controller
public class ExercitationController {
    @Autowired
    ExercitationServiceImpl exercitationService;

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    DepartmentServiceImpl departmentService;

    //查询所有实习生的请求
    @RequestMapping("/selectAll")
    public String List(Model model){
        List<Exercitation> exercitations = exercitationService.queryAllExercitation();
        for (Exercitation exercitation:exercitations){
            String departmentName = exercitationService.getDepartmentName(exercitation.getExdepartment());
            if(!departmentName.equals("部门被删了")) {
                exercitation.setDepartmentName(departmentName);
            }else{
                //如果部门被删了为空就更新实习生信息
                exercitationService.updateExercitationDepart(exercitation.getExid(),100);
                String departmentNameNew = exercitationService.getDepartmentName(100);
                exercitation.setDepartmentName(departmentNameNew);
            }
        }
        model.addAttribute("exemps",exercitations);
        return "/exemp/ExempList";
    }

    //跳转到添加实习生页面的请求
    @GetMapping("/toAddPage")
    public String toAddPage(Model model){
        List<Department> departments = departmentService.queryAllDepartment();
        //返回给前端修改实习生表中的部门下拉单
        model.addAttribute("departments",departments);
        return "/exemp/addPage";
    }

    //跳转到修改实习生页面的请求
    @GetMapping("/toUpdatePage{exid}")
    public String toUpdatePage(@PathVariable("exid") Integer exid ,Model model){
        List<Department> departments = departmentService.queryAllDepartment();
        Exercitation exercitation = exercitationService.queryExercitationById(exid);
        //返回给前端修改实习生表中的部门下拉单
        model.addAttribute("departments",departments);
        model.addAttribute("QExercitation",exercitation);
        return "/exemp/updatePage";
    }

    //添加实习生请求
    @PostMapping("/addExercitation")
    public  String addEmployee(@RequestParam("exname") String exname,
                               @RequestParam("exemail")String exemail,
                               Integer exgender,
                               @RequestParam("exdepartment") int exdepartment,
                               Integer foreignskill){

        exercitationService.addExercitation(new Exercitation(exname, exemail, exgender, exdepartment,foreignskill));
        return "redirect:/exemp/selectAll";
    }

    //修改实习生请求
    //其中可能会试用期调整
    @PostMapping("/updateExercitation")
    public String updateExercitation( @RequestParam("exid") int exid, @RequestParam("exname") String exname,
                                     @RequestParam("exemail")String exemail,
                                     Integer exgender,
                                     @RequestParam("exdepartment") int exdepartment,
                                     Integer foreignskill,
                                     @RequestParam("addTime") int addTime){
        exercitationService.updateExercitation(new Exercitation(exname,exemail,exgender,exdepartment,foreignskill));
        if(addTime>=0){
            exercitationService.addExerDate(exid,addTime);
        }else{
            exercitationService.subExerDate(exid,-addTime);
        }

        return "redirect:/exemp/selectAll";
    }

    //删除实习生请求
    @RequestMapping("/deleteExercitation{exid}")
    public String deleteExercitation(@PathVariable("exid") Integer exid){
        exercitationService.deleteExercitation(exid);
        return "redirect:/exemp/selectAll";
    }

    //实习生转正
    @RequestMapping("/changeExercitation{exid}")
    public String changeExercitation(@PathVariable("exid") Integer exid){

        Exercitation exercitation = exercitationService.queryExercitationById(exid);
        employeeService.addEmployee(new Employee(exercitation.getExname(),exercitation.getExemail(),exercitation.getExgender(),
                exercitation.getExdepartment()));
        exercitationService.deleteExercitation(exid);
        return "redirect:/exemp/selectAll";
    }
}
