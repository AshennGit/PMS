package com.cao.pms.part2.dao;

import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part2.pojo.Exercitation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface ExercitationDao {
    //查询所有实习生
    List<Exercitation> queryAllExercitation();

    //根据id查询实习生
    Exercitation queryExercitationById(@Param("exid") int exid);

    //添加实习生
    int addExercitation(Exercitation exercitation);

    //根据id删除实习生
    int deleteExercitation(int exid);

    //修改实习生信息
    int updateExercitation(Exercitation exercitation);

    //更新实习生部门
    int updateExercitationDepart(@Param("exid") int exid, @Param("exdepartment") int exdepartment);

    //试用期延期
    int addExerDate(@Param("exid") int exid, @Param("addTime") int addTime);

    //试用期减少
    int subExerDate(@Param("exid") int exid, @Param("addTime") int addTime);

    //修改实习生日薪
    int updateExerSalary(@Param("exid") int exid, @Param("salary") int salary);

}
