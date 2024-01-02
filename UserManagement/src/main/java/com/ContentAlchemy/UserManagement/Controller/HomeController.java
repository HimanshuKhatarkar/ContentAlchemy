package com.ContentAlchemy.UserManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ContentAlchemy.UserManagement.Models.UserDetails;
import com.ContentAlchemy.UserManagement.Services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    public UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";

        
    }
    @GetMapping("/register")
    public String register(){
        return "register";
        
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDetails user, HttpSession session){

        boolean f = userService.checkEmail(user.getEmail());
        if(f){
            session.setAttribute("msg","Email Already Exists");
        }
        else{
            UserDetails userdetails = userService.createUser(user);
            if(userdetails != null){
            session.setAttribute("msg","Registered Successfully");
            }else{
            session.setAttribute("msg","Registration Failed!");
            }
        }
        return "register";
    }
}
