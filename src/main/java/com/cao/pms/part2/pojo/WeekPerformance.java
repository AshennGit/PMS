package com.cao.pms.part2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WeekPerformance {
    private int pid;
    private int sun;
    private int mon;
    private int tue;
    private int wed;
    private int thu;
    private int fri;
    private int sat;
    private int eid;

    //数据库没有，不需要构造器
    private String eName;

    public WeekPerformance(int sun, int mon, int tue, int wed, int thu, int fri, int sat, int eid) {
        this.sun = sun;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.eid = eid;
    }

}
