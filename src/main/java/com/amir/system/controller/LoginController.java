package com.amir.system.controller;

import com.amir.user.UserModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    @RequestMapping("/showMyLoginPage")
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping("/suc")
    public String getSuc(Authentication authentication , Model model){
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getPrincipal());


        model.addAttribute("name", authentication.getName());
        return "suc";
    }

    @RequestMapping(value="/logoutUrl", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        cancelCookie(request, response);
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }



    void cancelCookie(HttpServletRequest request, HttpServletResponse response)
    {
        String cookieName = "remember-me";
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath(StringUtils.hasLength(request.getContextPath()) ? request.getContextPath() : "/");
        response.addCookie(cookie);
    }


}
