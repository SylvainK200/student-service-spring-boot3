package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.entities.Examination;
import com.kouemo.studentservice.feature.repositories.ExaminationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExaminationServiceImpl implements ExaminationService{
    private final ExaminationRepository examinationRepository;
    @Override
    public ExaminationRecord create(ExaminationRecord examination) {
        Examination exam = ExaminationRecord.map(examination);
        examinationRepository.save(exam);
        return examination;
    }

    @Override
    public ExaminationRecord findById(Long examinationId) {
        Optional<Examination> exam = examinationRepository.findById(examinationId);
        return exam.map(ExaminationRecord::map).orElse(null);
    }

    @Override
    public ExaminationRecord update(ExaminationRecord examination, Long examinationId) {
        Optional<Examination> optionalExamination = examinationRepository.findById(examinationId);
        optionalExamination.ifPresent(exam->{
            Examination updatedExam = ExaminationRecord.map(examination);
            updatedExam.setId(examinationId);
            examinationRepository.save(updatedExam);
        });
        throw new ObjectNotFoundException(Examination.class.getSimpleName(),examinationId);
    }

    @Override
    public Page<ExaminationRecord> findAllBySearch(int pageNumber, int size, String search, String columnSort) {
        Pageable pageable = PageRequest.of(pageNumber,size, Sort.by(columnSort));
        Page<ExaminationRecord> result = examinationRepository.findAllBySearch(search,pageable);
        return result;
    }

    @Override
    public ExaminationRecord delete(Long examinationId) {
        return null;
    }
}
