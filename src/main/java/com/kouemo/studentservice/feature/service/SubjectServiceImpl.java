package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.dtos.SubjectRecord;
import com.kouemo.studentservice.feature.entities.Examination;
import com.kouemo.studentservice.feature.entities.Subject;
import com.kouemo.studentservice.feature.repositories.SubjectRepository;
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
@RequiredArgsConstructor
@Transactional
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepository subjectRepository;
    @Override
    public SubjectRecord create(SubjectRecord subject) {
        Subject subjectCreate = SubjectRecord.map(subject);
        subjectRepository.save(subjectCreate);
        return subject;
    }

    @Override
    public SubjectRecord findById(Long subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        return subject.map(SubjectRecord::map).orElse(null);
    }

    @Override
    public SubjectRecord update(SubjectRecord subject, Long subjectId) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        optionalSubject.ifPresent(exam->{
            Subject updateSubject = SubjectRecord.map(subject);
            updateSubject.setId(subjectId);
            subjectRepository.save(updateSubject);
        });
        throw new ObjectNotFoundException(Subject.class.getSimpleName(),subjectId);
    }

    @Override
    public Page<SubjectRecord> findAllBySearch(int page, int size,String search, String columnSort) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(columnSort));
        Page<SubjectRecord> result = subjectRepository.findAllBySearch(search,pageable);
        return result;
    }

    @Override
    public SubjectRecord delete(Long subjectId) {
        return null;
    }
}
