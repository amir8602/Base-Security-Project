package com.amir.user;


import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("dto") @Valid UserModel userFromUi , BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "/register";
        }else{
            UserModel finalUserModel = userService.registerUser(userFromUi);
            System.out.println(finalUserModel);
            return "redirect:/";
        }
    }




}
