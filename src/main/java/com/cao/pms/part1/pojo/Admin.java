package com.cao.pms.part1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin {
    private int aid;
    private String username;
    private String password;

    //id自增不需要构造
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
