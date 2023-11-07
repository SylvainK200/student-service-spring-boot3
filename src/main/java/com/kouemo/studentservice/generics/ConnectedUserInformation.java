package com.kouemo.studentservice.generics;

import com.kouemo.studentservice.feature.entities.User;
import com.kouemo.studentservice.feature.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConnectedUserInformation {
    private final  UserRepository userRepository;
    public User getConectedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername()).orElse(null);

    }
}
