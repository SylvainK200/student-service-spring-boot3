package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.entities.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination,Long> {
}