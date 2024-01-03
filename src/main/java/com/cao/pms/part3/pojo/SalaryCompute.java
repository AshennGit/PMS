package com.cao.pms.part3.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalaryCompute {
    private int eid;
    private String ename;
    private String departName;
    private float dayPerformence;
    private float suggestSalary;
}
