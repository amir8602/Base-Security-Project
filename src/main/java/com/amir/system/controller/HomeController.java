package com.amir.system.controller;

import com.amir.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;


@Controller

public class HomeController {

    @GetMapping("/")
    private String getHome(){
        return "index";
    }

//    @RequestMapping("/showMyInfo")
//    private String showMyInfo(Principal principal , Model model){
//        model.addAttribute("name", principal.getName());
//        return "show";
//    }

    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute("dto") UserModel userFromUi){
        return "register";
    }




}
