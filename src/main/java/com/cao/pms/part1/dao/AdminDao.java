package com.cao.pms.part1.dao;

import com.cao.pms.part1.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminDao {
    Admin queryAdminByUsername(String username);
}
