package com.abdisalam.hotelbooking.controller;

import com.abdisalam.hotelbooking.dto.UserRegistrationDTO;
import com.abdisalam.hotelbooking.model.User;
import com.abdisalam.hotelbooking.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserRegistrationDTO());
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserRegistrationDTO userRegistrationDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "register";
        }

        if(!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())){
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "passwords do not match");
            return "register";
        }

        User user = new User();
        user.setUsername(userRegistrationDTO.getUsername());
        user.setPassword(userRegistrationDTO.getPassword());
        user.setRole("USER");


        try{
            userService.registerUser(user);
            return "redirect:/login";
        }catch(Exception e){
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
    }


    @GetMapping("/login")
    public String showLogin(Model model){
        return "login";
    }


}
