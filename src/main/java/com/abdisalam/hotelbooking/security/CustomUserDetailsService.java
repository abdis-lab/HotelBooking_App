package com.abdisalam.hotelbooking.security;


import com.abdisalam.hotelbooking.model.User;
import com.abdisalam.hotelbooking.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;

import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;


    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        User user  = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found "));


        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
                builder.password(user.getPassword());
                builder.roles(user.getRole());

        return builder.build();

    }


}
