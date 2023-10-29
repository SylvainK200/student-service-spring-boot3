package com.kouemo.studentservice.feature.services;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.dtos.ProfessorRecord;

import java.util.List;

public interface ProfessorService {
     ProfessorRecord create(ProfessorRecord professorRecord);
     ProfessorRecord update(ProfessorRecord professorRecord);
     ProfessorRecord findById(ProfessorRecord professorRecord);
     List<ProfessorRecord> findAllBySearch(String search);
     ProfessorRecord deleteById(String professorId);
}
