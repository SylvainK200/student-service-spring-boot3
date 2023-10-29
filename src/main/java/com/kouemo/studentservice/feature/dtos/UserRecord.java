package com.kouemo.studentservice.feature.dtos;

import com.kouemo.studentservice.feature.entities.User;

public record UserRecord(

        String username,
        String password,
        String emailAdress
) {
    public static User map(UserRecord record){
        return User.builder()
                .emailAddress(record.emailAdress())
                .password(record.password())
                .username(record.username())
                .build();
    }
}
