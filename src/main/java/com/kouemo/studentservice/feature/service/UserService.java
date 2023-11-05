package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();
    UserDto create(UserDto user);
    UserDto findById(Long userId);
    UserDto update(UserDto user, Long userId);

    Page<UserDto> findAllBySearch(int page , int size, String search, String columnSort);

    UserDto delete(Long userId);


}
