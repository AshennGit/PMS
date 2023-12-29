package com.cao.pms.part1.dao;

import com.cao.pms.part1.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminDao {
    //根据用户名查询
    Admin queryAdminByUsername(String username);

    //根据id查询
    Admin queryAdminByAid(@Param("aid") int aid);

    //修改信息
    int updateUser(Admin admin);
}
