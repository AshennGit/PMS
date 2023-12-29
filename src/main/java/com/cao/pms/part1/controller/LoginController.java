package com.cao.pms.part1.controller;

import com.cao.pms.part1.pojo.Admin;
import com.cao.pms.part1.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class LoginController {

    @Autowired
    private AdminServiceImpl adminService;

    //登陆请求的页面逻辑
    @RequestMapping("/login")
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model,
                            HttpSession session
    ){
        if(adminService.LoginService(username,password)!=0){
            session.setAttribute("username",username);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或密码错误！");
            return "index";
        }
    }

    //注销请求（干掉session）
    @RequestMapping("/signout")
    public String userSignout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }

    //跳转修改用户
    @RequestMapping("/toUpdateUser{username}")
    public String toUpdateUser(@PathVariable("username") String username, Model model){
        Admin user = adminService.queryAdminByUsername(username);
        model.addAttribute("user",user);

        return "/user/updateUser";
    }

    //修改账号和密码请求
    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("aid") Integer aid,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("newpassword") String newpassword,
                             @RequestParam("confirmpassword") String confirmpassword,
                             Model model,
                             HttpSession session){
        Admin user = adminService.queryAdminByAid(aid);
        //前提1，旧密码输入正确
        if(!password.equals(user.getPassword())){
            model.addAttribute("updatemsg1","密码错误！");
            model.addAttribute("user",user);
            return "/user/updateUser";
        }else{
            //前提2，新密码确认无误或不输入
            if(!newpassword.equals(confirmpassword)){
                model.addAttribute("updatemsg2","两次输入的密码不一致!");
                model.addAttribute("user",user);
                return "/user/updateUser";
            }else {
                Admin upUser = new Admin(username, password);
                if(!newpassword.equals("")){
                    upUser.setPassword(newpassword);
                }
                upUser.setAid(aid);
                adminService.updateUser(upUser);
                model.addAttribute("msgyes","修改成功，请重新登陆");
            }
        }
        session.invalidate();
        return "index";
    }
}
