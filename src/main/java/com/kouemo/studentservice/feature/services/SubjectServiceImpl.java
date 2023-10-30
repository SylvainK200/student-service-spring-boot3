package com.kouemo.studentservice.feature.services;

import com.kouemo.studentservice.feature.dtos.SubjectRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{
    @Override
    public SubjectRecord create(SubjectRecord subjectRecord) {
        return null;
    }

    @Override
    public SubjectRecord update(SubjectRecord subjectRecord) {
        return null;
    }

    @Override
    public SubjectRecord findById(SubjectRecord subjectRecord) {
        return null;
    }

    @Override
    public List<SubjectRecord> findAllBySearch(String search) {
        return null;
    }

    @Override
    public SubjectRecord deleteById(String subjectId) {
        return null;
    }
}
