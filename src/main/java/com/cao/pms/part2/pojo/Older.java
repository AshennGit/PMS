package com.cao.pms.part2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Older {

    private int eid;

    private String name;

    private String address;

    private int age;

    private int service_year;

    private String teleph;

    public Older( String name,String address, int age, int service_year, String teleph) {
        this.address = address;
        this.name = name;
        this.age = age;
        this.service_year = service_year;
        this.teleph = teleph;
    }

    public Older(int eid, String name,String address, int age, int service_year, String teleph) {
        this.eid = eid;
        this.address = address;
        this.name = name;
        this.age = age;
        this.service_year = service_year;
        this.teleph = teleph;
    }

    @Override
    public String toString() {
        return "Older{" +
                "eid=" + eid +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", service_year=" + service_year +
                ", teleph='" + teleph + '\'' +
                '}';
    }
}
