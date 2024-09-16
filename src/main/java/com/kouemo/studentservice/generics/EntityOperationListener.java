package com.kouemo.studentservice.generics;

import com.kouemo.studentservice.feature.entities.AbstractEntity;
import com.kouemo.studentservice.feature.entities.User;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
public class EntityOperationListener {

    @PreUpdate
    private void preUdateEntity(AbstractEntity abstractEntity){
        abstractEntity.setUpdatedAt(Instant.now());
    }

    @PrePersist
    private void prePersistEntity(AbstractEntity abstractEntity){
        abstractEntity.setCreatedAt(Instant.now());
    }
}
