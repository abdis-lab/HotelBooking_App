package com.abdisalam.hotelbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/index")
    public String showLandingPage(){
        return "homePage";
    }
}
