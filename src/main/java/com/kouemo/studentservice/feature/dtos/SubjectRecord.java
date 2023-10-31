package com.kouemo.studentservice.feature.dtos;

import com.kouemo.studentservice.feature.entities.Subject;

public record SubjectRecord(
    String name,
    String objectives,
    long credit,
    UserRecord professor
) {

    public static Subject map(SubjectRecord subject){
        return Subject.builder()
                .name(subject.name())
                .credit(subject.credit())
                .objectives(subject.objectives())
                .professor(UserRecord.map(subject.professor()))
                .build();
    }
}
