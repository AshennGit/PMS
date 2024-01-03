package com.cao.pms.part2.service.Impl;

import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.service.Impl.DepartmentServiceImpl;
import com.cao.pms.part2.dao.ExercitationDao;
import com.cao.pms.part2.pojo.Exercitation;
import com.cao.pms.part2.service.ExercitationService;
import com.cao.pms.part3.pojo.Work;
import com.cao.pms.part3.service.Impl.WorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercitationServiceImpl implements ExercitationService {

    @Autowired
    private ExercitationDao exercitationDao;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private WorkServiceImpl workService;

    @Override
    public List<Exercitation> queryAllExercitation() {
        List<Exercitation> exercitations = exercitationDao.queryAllExercitation();
        Work work = workService.getWorkDay(1);//本月工作日
        int workday = work.getWorkday();
        for (Exercitation exercitation:exercitations){
            //部门赋值
            String departmentName = getDepartmentName(exercitation.getExdepartment());
            if(!departmentName.equals("部门被删了")) {
                exercitation.setDepartmentName(departmentName);
            }else{
                //如果部门被删了为空就更新实习生信息
                exercitationDao.updateExercitationDepart(exercitation.getExid(),100);
                String departmentNameNew = getDepartmentName(100);
                exercitation.setDepartmentName(departmentNameNew);
            }
            //月薪赋值
            int MonSalary=workday*exercitation.getSalary();
            exercitation.setMonthSalary(MonSalary);
        }
        return exercitations;
    }

    @Override
    public Exercitation queryExercitationById(int exid) {
        return exercitationDao.queryExercitationById(exid);
    }

    @Override
    public int addExercitation(Exercitation exercitation) {
        return exercitationDao.addExercitation(exercitation);
    }

    @Override
    public int deleteExercitation(int exid) {
        return exercitationDao.deleteExercitation(exid);
    }

    @Override
    public int updateExercitation(Exercitation exercitation) {
        return exercitationDao.updateExercitation(exercitation);
    }

    @Override
    public int updateExercitationDepart(int exid, int exdepartment) {
        return exercitationDao.updateExercitationDepart(exid,exdepartment);
    }

    @Override
    public int addExerDate(int exid, int addTime) {
        return exercitationDao.addExerDate(exid,addTime);
    }

    @Override
    public int subExerDate(int exid, int addTime) {
        return exercitationDao.subExerDate(exid,addTime);
    }

    @Override
    public int updateExerSalary(int exid, int salary) {
        return exercitationDao.updateExerSalary(exid,salary);
    }

    //获取部门服务
    public String getDepartmentName(int did){
        Department department = departmentService.queryDepartmentById(did);
        if(department!=null){
            return department.getDepartmentName();
        }else{
            return "部门被删了";
        }
    }


}
