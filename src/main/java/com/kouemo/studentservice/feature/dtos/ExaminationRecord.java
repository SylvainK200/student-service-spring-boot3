package com.kouemo.studentservice.feature.dtos;

import com.kouemo.studentservice.feature.entities.Examination;
import com.kouemo.studentservice.generics.enums.EnumSession;

import java.time.Instant;

public record ExaminationRecord (
        double rating,
        String session,
        Instant dateExamination,

        SubjectRecord subject,
        UserRecord professorRecord

){
    public static Examination map(ExaminationRecord examination){
        return Examination.builder()
                .rating(examination.rating())
                .session(getSession(examination.session()))
                .dateExamination(examination.dateExamination())
                .subject(SubjectRecord.map(examination.subject()))
                .professor(UserRecord.map(examination.professorRecord()))
                .build();
    }

    public static ExaminationRecord map(Examination examination){
        return new ExaminationRecord(
                examination.getRating(),
                examination.getSession().getKey(),
                examination.getDateExamination(),
                SubjectRecord.map(examination.getSubject()),
                UserRecord.map(examination.getProfessor())
        );
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
