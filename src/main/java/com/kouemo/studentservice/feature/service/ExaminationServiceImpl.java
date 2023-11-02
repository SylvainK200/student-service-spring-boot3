package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.ExaminationDto;
import com.kouemo.studentservice.feature.dtos.ExaminationDtoInterface;
import com.kouemo.studentservice.feature.entities.Examination;
import com.kouemo.studentservice.feature.repositories.ExaminationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ExaminationServiceImpl implements ExaminationService{
    private final ExaminationRepository examinationRepository;
    @Override
    public ExaminationDto create(ExaminationDto examination) {
        Examination exam = ExaminationDto.map(examination);
        examinationRepository.save(exam);
        return examination;
    }

    @Override
    public ExaminationDto findById(Long examinationId) {
        Optional<Examination> exam = examinationRepository.findById(examinationId);
        return exam.map(ExaminationDto::map).orElse(null);
    }

    @Override
    public ExaminationDto update(ExaminationDto examination, Long examinationId) {
        Optional<Examination> optionalExamination = examinationRepository.findById(examinationId);
        optionalExamination.ifPresent(exam->{
            Examination updatedExam = ExaminationDto.map(examination);
            updatedExam.setId(examinationId);
            examinationRepository.save(updatedExam);
        });
        throw new ObjectNotFoundException(Examination.class.getSimpleName(),examinationId);
    }

    @Override
    public Page<ExaminationDto> findAllBySearch(int pageNumber, int size, String search, String columnSort) {
        Pageable pageable = PageRequest.of(pageNumber,size);
        Page<ExaminationDtoInterface> result = examinationRepository.findAllBySearch(search,pageable);
        List<ExaminationDto> content = result.getContent().stream().map(ExaminationDto::map).collect(Collectors.toList());
        return new PageImpl<>(content,pageable,result.getTotalElements());
    }

    @Override
    public ExaminationDto delete(Long examinationId) {
        return null;
    }
}
