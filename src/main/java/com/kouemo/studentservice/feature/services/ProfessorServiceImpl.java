package com.kouemo.studentservice.feature.services;

import com.kouemo.studentservice.feature.dtos.ProfessorRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService{
    @Override
    public ProfessorRecord create(ProfessorRecord professorRecord) {
        return null;
    }

    @Override
    public ProfessorRecord update(ProfessorRecord professorRecord) {
        return null;
    }

    @Override
    public ProfessorRecord findById(ProfessorRecord professorRecord) {
        return null;
    }

    @Override
    public List<ProfessorRecord> findAllBySearch(String search) {
        return null;
    }

    @Override
    public ProfessorRecord deleteById(String professorId) {
        return null;
    }
}
