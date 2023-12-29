package com.cao.pms.part1.service.Impl;

import com.cao.pms.part1.dao.AdminDao;
import com.cao.pms.part1.pojo.Admin;
import com.cao.pms.part1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin queryAdminByUsername(String username) {
        return adminDao.queryAdminByUsername(username);
    }

    @Override
    public Admin queryAdminByAid(int aid) {
        return adminDao.queryAdminByAid(aid);
    }

    @Override
    public int updateUser(Admin admin) {
        return adminDao.updateUser(admin);
    }

    //登陆服务
    public int LoginService(String username,String password){
        Admin admin = adminDao.queryAdminByUsername(username);
        String str=null;
        if(admin==null){
            return 0;
        }else {
            str = admin.getPassword();
        }
        if(str.equals(password)){
            return 1;
        }
        return 0;
    }

}
