package com.kouemo.studentservice.feature.services;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.dtos.UserRecord;

import java.util.List;

public interface UserService {
    public UserRecord create(UserRecord userRecord);
    public UserRecord update(UserRecord userRecord);
    public UserRecord findById(UserRecord userRecord);
    public List<UserRecord> findAllBySearch(String search);
    public UserRecord deleteById(String userId);
}
