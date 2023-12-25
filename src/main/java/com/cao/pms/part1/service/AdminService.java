package com.cao.pms.part1.service;

import com.cao.pms.part1.pojo.Admin;

public interface AdminService {
    Admin queryAdminByUsername(String username);
}
