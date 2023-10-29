package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
