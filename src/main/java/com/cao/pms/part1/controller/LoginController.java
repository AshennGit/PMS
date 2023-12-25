package com.cao.pms.part1.controller;

import com.cao.pms.part1.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/user")
@Controller
public class LoginController {

    @Autowired
    private AdminServiceImpl adminService;

    //登陆请求的页面逻辑
    @RequestMapping("/login")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        if(adminService.LoginService(username,password)!=0){
            return "dashboard";
        }else{
            model.addAttribute("msg","用户名或密码错误！");
            return "index";
        }
    }
}
