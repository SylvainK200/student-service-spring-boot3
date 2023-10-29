package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
