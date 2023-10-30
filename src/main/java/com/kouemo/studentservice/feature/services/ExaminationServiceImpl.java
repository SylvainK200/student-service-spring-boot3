package com.kouemo.studentservice.feature.services;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExaminationServiceImpl implements ExaminationService{
    @Override
    public ExaminationRecord create(ExaminationRecord examinationRecord) {
        return null;
    }

    @Override
    public ExaminationRecord update(ExaminationRecord examinationRecord) {
        return null;
    }

    @Override
    public ExaminationRecord findById(ExaminationRecord examinationRecord) {
        return null;
    }

    @Override
    public List<ExaminationRecord> findAllBySearch(String search) {
        return null;
    }

    @Override
    public ExaminationRecord deleteById(String examinationId) {
        return null;
    }
}
