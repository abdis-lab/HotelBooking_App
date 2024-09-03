package com.abdisalam.hotelbooking.controller;

import com.abdisalam.hotelbooking.repository.UserRepository;
import com.abdisalam.hotelbooking.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {


    private final UserService userService;

    public HomePageController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/index")
    public String landingPage(Model model, Authentication authentication){
        if(authentication != null && authentication.isAuthenticated()){
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", authentication.getName());
        }else{
            model.addAttribute("isAuthenticated", false);
        }

        return "homePage";
    }


}
