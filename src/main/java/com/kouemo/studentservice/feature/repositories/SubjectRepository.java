package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
