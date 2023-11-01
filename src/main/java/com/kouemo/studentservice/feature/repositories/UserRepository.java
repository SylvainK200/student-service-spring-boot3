package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.dtos.UserRecord;
import com.kouemo.studentservice.feature.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,
    value = "",
    countQuery = "")
    Page<UserRecord> findAllBySearch(String search, Pageable pageable);
}
