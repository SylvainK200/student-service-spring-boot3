package com.kouemo.studentservice.feature.service;

import com.kouemo.studentservice.feature.dtos.SubjectDto;
import com.kouemo.studentservice.feature.dtos.SubjectDtoInterface;
import com.kouemo.studentservice.feature.entities.Subject;
import com.kouemo.studentservice.feature.repositories.SubjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepository subjectRepository;
    @Override
    public SubjectDto create(SubjectDto subject) {
        Subject subjectCreate = SubjectDto.map(subject);
        subjectRepository.save(subjectCreate);
        return subject;
    }

    @Override
    public SubjectDto findById(Long subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        return subject.map(SubjectDto::map).orElse(null);
    }

    @Override
    public SubjectDto update(SubjectDto subject, Long subjectId) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        optionalSubject.ifPresent(exam->{
            Subject updateSubject = SubjectDto.map(subject);
            updateSubject.setId(subjectId);
            subjectRepository.save(updateSubject);
        });
        throw new ObjectNotFoundException(Subject.class.getSimpleName(),subjectId);
    }

    @Override
    public Page<SubjectDto> findAllBySearch(int page, int size, String search, String columnSort) {
        Pageable pageable = PageRequest.of(page,size);
        Page<SubjectDtoInterface> result = subjectRepository.findAllBySearch(search,pageable);
        List<SubjectDto> content = result.getContent().stream().map(SubjectDto::map).toList();
        return new PageImpl<>(content,pageable,result.getTotalElements());
    }

    @Override
    public SubjectDto delete(Long subjectId) {
        return null;
    }
}
