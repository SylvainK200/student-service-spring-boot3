package com.kouemo.studentservice.feature.services;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.dtos.UserRecord;

import java.util.List;

public interface UserService {
     UserRecord create(UserRecord userRecord);
     UserRecord update(UserRecord userRecord);
     UserRecord findById(UserRecord userRecord);
     UserRecord findByUserName(String username);
     List<UserRecord> findAllBySearch(String search);
     UserRecord deleteById(String userId);
}
