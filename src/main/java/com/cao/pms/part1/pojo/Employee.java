package com.cao.pms.part1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//员工表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer eid;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer department;

    //存放部门真实名
    private String departmentName;
}
