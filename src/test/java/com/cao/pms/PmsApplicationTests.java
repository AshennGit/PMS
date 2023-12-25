package com.cao.pms;

import com.cao.pms.part1.pojo.Admin;
import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part1.pojo.Employee;
import com.cao.pms.part1.service.Impl.AdminServiceImpl;
import com.cao.pms.part1.service.Impl.DepartmentServiceImpl;
import com.cao.pms.part1.service.Impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@MapperScan("com.cao.pms.part1.dao")
@SpringBootTest
class PmsApplicationTests {


    @Autowired
    DataSource dataSource;

    @Autowired
    DepartmentServiceImpl service;

    @Autowired
    EmployeeServiceImpl service2;

    @Autowired
    AdminServiceImpl service3;

    @Test
    void contextLoads() {
        Employee employee = service2.queryEmployeeById(1001);
        System.out.println(employee);
    }

    @Test
    void Data() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    @Test
    void SerTest(){
        Admin admin = service3.queryAdminByUsername("admin");
        System.out.println(admin);
    }

}
