package com.cao.pms.part1.service;

import com.cao.pms.part1.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService {
    Admin queryAdminByUsername(String username);

    //根据id查询
    Admin queryAdminByAid(int aid);

    //修改信息
    int updateUser(Admin admin);
}
