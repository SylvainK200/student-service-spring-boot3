package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.ExaminationDto;
import org.springframework.data.domain.Page;

public interface ExaminationService {
    ExaminationDto create(ExaminationDto examination);
    ExaminationDto findById(Long examinationId);
    ExaminationDto update(ExaminationDto examination, Long examinationId);

    Page<ExaminationDto> findAllBySearch(int page, int size, String search, String columnSort);

    ExaminationDto delete(Long examinationId);
}
