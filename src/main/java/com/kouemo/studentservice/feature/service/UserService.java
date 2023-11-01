package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.UserRecord;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    UserRecord create(UserRecord user);
    UserRecord findById(Long userId);
    UserRecord update(UserRecord user, Long userId);

    Page<UserRecord> findAllBySearch(int page , int size, String search, String columnSort);

    UserRecord delete(Long userId);


}
