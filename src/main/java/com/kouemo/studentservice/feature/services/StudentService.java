package com.kouemo.studentservice.feature.services;


import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.dtos.StudentRecord;

import java.util.List;

public interface StudentService {
     StudentRecord create(StudentRecord studentRecord);
     StudentRecord update(StudentRecord studentRecord);
     StudentRecord findById(StudentRecord studentRecord);
     List<StudentRecord> findAllBySearch(String search);
     StudentRecord deleteById(String studentId);
}
