package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.SubjectRecord;
import com.kouemo.studentservice.feature.dtos.UserRecord;
import org.springframework.data.domain.Page;

public interface SubjectService {
    SubjectRecord create(SubjectRecord subject);
    SubjectRecord findById(Long subjectId);
    SubjectRecord update(SubjectRecord subject, Long subjectId);

    /**
     * This method search all subjects with an attribute containing the substring search
     * @param page
     * @param size
     * @param search
     * @param columnSort
     * @return all the subjects with any attribute having search string as substring
     */
    Page<SubjectRecord> findAllBySearch(int page, int size, String search, String columnSort);

    SubjectRecord delete(Long subjectId);
}
