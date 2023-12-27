package com.cao.pms.part1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//员工表
@Data
@NoArgsConstructor
public class Employee {
    private Integer eid;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer department;

    //存放部门真实名(数据库没有该表，不需要构造)
    private String departmentName;

    public Employee(String lastName, String email, Integer gender, Integer department) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }
}
