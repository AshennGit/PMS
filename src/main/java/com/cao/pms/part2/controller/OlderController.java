package com.cao.pms.part2.controller;

import com.cao.pms.part1.pojo.Department;
import com.cao.pms.part2.pojo.Exercitation;
import com.cao.pms.part2.pojo.Older;
import com.cao.pms.part2.service.Impl.OlderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/older")
@Controller
public class OlderController {
    @Autowired
    private OlderServiceImpl impl;

    @RequestMapping("/show")
    public String show(Model model){
        List<Older> older = impl.selectOlder();
        model.addAttribute("laoren",older);
        return "/older/older";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage(){
        return "/older/addPage";
    }

    @PostMapping("/addOlder")
    public String add(@RequestParam("name") String name,
                      @RequestParam("address")String address,
                      @RequestParam("teleph") String teleph,
                      @RequestParam("age") String age,
                      @RequestParam("service_year") String year
                      ){
        int a = Integer.parseInt(age);
        int b = Integer.parseInt(year);

        impl.addOlder(new Older(name,address,a,b,teleph));
        return "redirect:/older/show";
    }

    @RequestMapping("/deleteOlder{teleph}")
    public String deleteOlder(@PathVariable("teleph") String teleph){
        impl.deleteOlder(teleph);
        return "redirect:/older/show";
    }

    @GetMapping("/toUpdatePage{teleph}")
    public String toUpdatePage(@PathVariable("teleph") String teleph ,Model model){

        Older old  = impl.selectaOlder(teleph);
        model.addAttribute("laoren",old);

        return "/older/updatePage";
    }

    @PostMapping("/updateOlder")
    public String updateOlder(@RequestParam("eid") int eid,
                              @RequestParam("name") String name,
                              @RequestParam("address")String address,
                              @RequestParam("teleph") String teleph,
                              @RequestParam("age") String age,
                              @RequestParam("service_year") String year){
        int a = Integer.parseInt(age);
        int b = Integer.parseInt(year);
        impl.updateOlder(new Older(eid,name,address,a,b,teleph));

        return "redirect:/older/show";
    }
}
