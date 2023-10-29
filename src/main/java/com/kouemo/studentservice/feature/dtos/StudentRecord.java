package com.kouemo.studentservice.feature.dtos;

import com.kouemo.studentservice.feature.entities.Student;

public record StudentRecord(
        String firstname,
        String lastname,
        String serialNumber
) {
    public static Student map(StudentRecord student){
        return Student.builder()
                .firstname(student.firstname())
                .lastname(student.lastname())
                .serialNumber(student.serialNumber())
                .build();
    }
}
