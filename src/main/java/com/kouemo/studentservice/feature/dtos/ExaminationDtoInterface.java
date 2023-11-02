package com.kouemo.studentservice.feature.dtos;

import java.time.Instant;

public interface ExaminationDtoInterface extends SubjectDtoInterface{

    double getRating();
    String getSession();
    Instant getDateExamination();
    Long getId();


    Long getProfessorId();
    String getProfessorName();
    String getProfessorEmailAddress();

    String getProfessorPhoneNumber();


    String getStudentName();
    Long getStudentId();
    String getStudentPhoneNumber();

    String getStudentEmailAddress();


}
