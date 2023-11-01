package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.dtos.SubjectRecord;
import com.kouemo.studentservice.feature.entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    @Query(nativeQuery = true,
            value="",
            countQuery = "")
    Page<SubjectRecord> findAllBySearch(String search, Pageable pageable);
}
