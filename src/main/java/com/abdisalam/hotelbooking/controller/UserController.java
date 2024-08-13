package com.abdisalam.hotelbooking.controller;

import com.abdisalam.hotelbooking.model.User;
import com.abdisalam.hotelbooking.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("userRegistration", new User());
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(User user){
        userService.registerUser(user);
        return "redirect:/login";
    }



}
