package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.dtos.UserRecord;
import org.springframework.data.domain.Page;

public interface ExaminationService {
    ExaminationRecord create(ExaminationRecord examination);
    ExaminationRecord findById(Long examinationId);
    ExaminationRecord update(ExaminationRecord examination,  Long examinationId);

    Page<ExaminationRecord> findAllBySearch( int page, int size,String search,String columnSort);

    ExaminationRecord delete(Long examinationId);
}
