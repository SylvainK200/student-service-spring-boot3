package com.kouemo.studentservice.feature.services;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.dtos.SubjectRecord;

import java.util.List;

public interface SubjectService {
     SubjectRecord create(SubjectRecord subjectRecord);
     SubjectRecord update(SubjectRecord subjectRecord);
     SubjectRecord findById(SubjectRecord subjectRecord);
     List<SubjectRecord> findAllBySearch(String search);
     SubjectRecord deleteById(String subjectId);
}
