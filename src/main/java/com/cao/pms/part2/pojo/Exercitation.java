package com.cao.pms.part2.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

//实习生
@NoArgsConstructor
@Data
public class Exercitation {
    private Integer exid;
    private String exname;
    private String exemail;
    private Integer exgender;
    private Integer exdepartment;
    private Integer foreignskill;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date exdate;

    //存放部门真实名(数据库没有该表，不需要构造)
    private String departmentName;

    public Exercitation(String exname, String exemail, Integer exgender, Integer exdepartment, Integer foreignskill) {
        this.exname = exname;
        this.exemail = exemail;
        this.exgender = exgender;
        this.exdepartment = exdepartment;
        this.foreignskill = foreignskill;
    }
}
