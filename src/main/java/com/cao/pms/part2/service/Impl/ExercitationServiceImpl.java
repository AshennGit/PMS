package com.cao.pms.part2.service.Impl;

import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.service.Impl.DepartmentServiceImpl;
import com.cao.pms.part2.dao.ExercitationDao;
import com.cao.pms.part2.pojo.Exercitation;
import com.cao.pms.part2.service.ExercitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercitationServiceImpl implements ExercitationService {

    @Autowired
    private ExercitationDao exercitationDao;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Override
    public List<Exercitation> queryAllExercitation() {
        return exercitationDao.queryAllExercitation();
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
