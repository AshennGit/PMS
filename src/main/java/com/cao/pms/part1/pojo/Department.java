package com.cao.pms.part1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门表
@Data
@NoArgsConstructor
public class Department {
    private Integer did;
    private String departmentName;
    private Integer parentdepart;
    private String departinfo;

    //数据库没有的属性
    private int empNums;
    private String parentName;

    public Department(String departmentName, Integer parentdepart, String departinfo) {
        this.departmentName = departmentName;
        this.parentdepart = parentdepart;
        this.departinfo = departinfo;
    }
}
