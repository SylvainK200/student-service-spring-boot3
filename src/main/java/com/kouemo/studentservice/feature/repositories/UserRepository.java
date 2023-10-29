package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
