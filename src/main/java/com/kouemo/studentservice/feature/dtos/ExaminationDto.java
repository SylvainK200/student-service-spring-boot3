package com.kouemo.studentservice.feature.dtos;

import com.kouemo.studentservice.feature.entities.Examination;
import com.kouemo.studentservice.generics.enums.EnumSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExaminationDto{
    private double rating;
    private String session;
    private Instant dateExamination;

    private SubjectDto subject;
    private UserDto professor;

    private UserDto student;
    public static Examination map(ExaminationDto examination){
        return Examination.builder()
                .rating(examination.getRating())
                .session(getSession(examination.getSession()))
                .dateExamination(examination.getDateExamination())
                .subject(SubjectDto.map(examination.getSubject()))
                .professor(UserDto.map(examination.getProfessor()))
                .student(UserDto.map(examination.getStudent()))
                .build();
    }

    public static ExaminationDto map(Examination examination){
        return new ExaminationDto(
                examination.getRating(),
                examination.getSession().getKey(),
                examination.getDateExamination(),
                SubjectDto.map(examination.getSubject()),
                UserDto.map(examination.getProfessor()),
                UserDto.map(examination.getStudent())
        );
    }

    public static ExaminationDto map(ExaminationDtoInterface examination){
        return ExaminationDto.builder()
                .rating(examination.getRating())
                .session(examination.getSession())
                .dateExamination(examination.getDateExamination())
                .subject(SubjectDto.builder()
                        .name(examination.getSubjectName())
                        .credit(examination.getSubjectCredit())
                        .build())
                .professor(UserDto.builder()
                        .id(examination.getProfessorId())
                        .fullName(examination.getProfessorName())
                        .emailAdress(examination.getProfessorEmailAddress())
                        .build())
                .student(UserDto.builder()
                        .fullName(examination.getStudentName())
                        .emailAdress(examination.getStudentEmailAddress())
                        .build())
                .build();
    }

    public static EnumSession getSession(String session){
       if(session.equals(EnumSession.EXAM.getKey())){
           return EnumSession.EXAM;
       }
       else if(session.equals(EnumSession.CONTINUOUS_CONTROL.getKey())){
           return EnumSession.CONTINUOUS_CONTROL;
       }
       else if(session.equals(EnumSession.PROJECT.getKey())){
           return EnumSession.PROJECT;
       }
       else if(session.equals(EnumSession.RATTRAPING.getKey())){
           return EnumSession.RATTRAPING;
       }
       return EnumSession.PROJECT;
    }

}
