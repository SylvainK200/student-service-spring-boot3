package com.kouemo.studentservice.feature.dtos;

import com.kouemo.studentservice.feature.entities.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectDto {

    private Long id;
    private String name;
    private String objectives;
    private long credit;
    private UserDto professor;


    public static Subject map(SubjectDto subject){
        return Subject.builder()
                .id(subject.getId())
                .name(subject.getName())
                .credit(subject.getCredit())
                .objectives(subject.getObjectives())
                .professor(UserDto.map(subject.getProfessor()))
                .build();
    }

    public static SubjectDto map(Subject subject){
        return new SubjectDto(subject.getId(), subject.getName(), subject.getObjectives(), subject.getCredit(), UserDto.map(subject.getProfessor()));
    }

    public static SubjectDto map(SubjectDtoInterface subject){
        return SubjectDto.builder()
                .id(subject.getSubjectId())
                .credit(subject.getSubjectCredit())
                .name(subject.getSubjectName())
                .objectives(subject.getSubjectObjectives())
                .build();
    }
}
