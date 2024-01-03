package com.cao.pms.part2.service;

import com.cao.pms.part2.pojo.Exercitation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExercitationService {
    //查询所有实习生
    List<Exercitation> queryAllExercitation();

    //根据id查询实习生
    Exercitation queryExercitationById(int exid);

    //添加实习生
    int addExercitation(Exercitation exercitation);

    //根据id删除实习生
    int deleteExercitation(int exid);

    //修改实习生信息
    int updateExercitation(Exercitation exercitation);

    //更新实习生部门
    int updateExercitationDepart(int exid, int exdepartment);

    //试用期延期
    int addExerDate(int exid, int addTime);

    //试用期减少
    int subExerDate(int exid, int addTime);

    int updateExerSalary(int exid,int salary);
}
