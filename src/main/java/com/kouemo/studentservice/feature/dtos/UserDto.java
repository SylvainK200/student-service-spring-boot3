package com.kouemo.studentservice.feature.dtos;

import com.kouemo.studentservice.feature.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto{
    private Long id;
    private String username;
    private String emailAdress;
    private String address;
    private String fullName;
    private double salary;
    private String serialNumber;
    public static User map(UserDto record){
        return User.builder()
                .id(record.getId())
                .emailAddress(record.getEmailAdress())
                .username(record.getUsername())
                .build();
    }

    public static UserDto map(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .emailAdress(user.getEmailAddress())
                .address(user.getAddress())
                .fullName(user.getFirstname()+" "+user.getLastname())
                .salary(user.getSalary())
                .serialNumber(user.getSerialNumber())
                .build();
    }

    public static UserDto map(UserDtoInterface user){
        return UserDto.builder()
                .id(user.getUserId())
                .username(user.getUsername())
                .emailAdress(user.getEmailAddress())
                .address(user.getAddress())
                .fullName(user.getFullName())
                .salary(user.getSalary())
                .serialNumber(user.getSerialNumber())
                .build();
    }
}
