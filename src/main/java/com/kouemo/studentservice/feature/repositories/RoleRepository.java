package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
