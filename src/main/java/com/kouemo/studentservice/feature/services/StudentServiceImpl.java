package com.kouemo.studentservice.feature.services;

import com.kouemo.studentservice.feature.dtos.StudentRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    @Override
    public StudentRecord create(StudentRecord studentRecord) {
        return null;
    }

    @Override
    public StudentRecord update(StudentRecord studentRecord) {
        return null;
    }

    @Override
    public StudentRecord findById(StudentRecord studentRecord) {
        return null;
    }

    @Override
    public List<StudentRecord> findAllBySearch(String search) {
        return null;
    }

    @Override
    public StudentRecord deleteById(String studentId) {
        return null;
    }
}
