package com.abdisalam.hotelbooking.service;

import com.abdisalam.hotelbooking.model.User;
import com.abdisalam.hotelbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    public PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user){
        if(!user.getPassword().equals(user.getConfirmPassword())){
            throw new RuntimeException("Password do not match");
        }

        User createdUser = new User();
        createdUser.setUsername(user.getUsername());
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
        createdUser.setRole("USER");

        userRepository.save(user);

    }



}
