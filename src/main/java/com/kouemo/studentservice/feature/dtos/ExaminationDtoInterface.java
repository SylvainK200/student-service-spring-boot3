package com.kouemo.studentservice.feature.dtos;

import java.time.Instant;

public interface ExaminationDtoInterface extends SubjectDtoInterface{

    double getRating();
    String getSession();
    Instant getDateExamination();


    String getProfessorName();
    String getProfessorEmailAddress();

    String getProfessorPhoneNumber();


    String getStudentName();
    String getStudentPhoneNumber();

    String getStudentEmailAddress();


}
