package com.kouemo.studentservice.feature.services;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;

import java.util.List;

public interface ExaminationService {

    public ExaminationRecord create(ExaminationRecord examinationRecord);
    public ExaminationRecord update(ExaminationRecord examinationRecord);
    public ExaminationRecord findById(ExaminationRecord examinationRecord);
    public List<ExaminationRecord> findAllBySearch(String search);
    public ExaminationRecord deleteById(String examinationId);
}
