package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.dtos.ExaminationRecord;
import com.kouemo.studentservice.feature.entities.Examination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination,Long> {

    @Query(nativeQuery = true, value = "",countQuery = "")
    Page<ExaminationRecord> findAllBySearch(String search, Pageable pageable);
}
