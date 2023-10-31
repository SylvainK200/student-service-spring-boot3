package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.entities.Subject;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
