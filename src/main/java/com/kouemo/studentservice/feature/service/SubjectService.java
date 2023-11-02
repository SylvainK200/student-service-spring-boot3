package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.SubjectDto;
import org.springframework.data.domain.Page;

public interface SubjectService {
    SubjectDto create(SubjectDto subject);
    SubjectDto findById(Long subjectId);
    SubjectDto update(SubjectDto subject, Long subjectId);

    /**
     * This method search all subjects with an attribute containing the substring search
     * @param page
     * @param size
     * @param search
     * @param columnSort
     * @return all the subjects with any attribute having search string as substring
     */
    Page<SubjectDto> findAllBySearch(int page, int size, String search, String columnSort);

    SubjectDto delete(Long subjectId);
}
