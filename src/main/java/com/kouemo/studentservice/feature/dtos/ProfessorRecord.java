package com.kouemo.studentservice.feature.dtos;

import com.kouemo.studentservice.feature.entities.Professor;

import java.util.List;
import java.util.stream.Collectors;

public record ProfessorRecord(
        String address,
        String name,
        String phoneNumber,
        double salary,
        List<SubjectRecord> subjects
) {
    public static Professor map(ProfessorRecord professor){
        return Professor.builder()
                .address(professor.address())
                .name(professor.name())
                .phoneNumber(professor.phoneNumber())
                .salary(professor.salary())
                .subjects(professor.subjects().stream()
                        .map(SubjectRecord::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
