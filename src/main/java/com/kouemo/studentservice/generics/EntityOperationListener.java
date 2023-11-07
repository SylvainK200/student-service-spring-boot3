package com.kouemo.studentservice.generics;

import com.kouemo.studentservice.feature.entities.AbstractEntity;
import com.kouemo.studentservice.feature.entities.User;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@RequiredArgsConstructor
@Component
public class EntityOperationListener {

    private final ConnectedUserInformation connectedUserInformation;
    @PreUpdate
    private void preUdateEntity(AbstractEntity abstractEntity){
        User connectedUser = connectedUserInformation.getConectedUser();
        abstractEntity.setUpdatedAt(Instant.now());
        abstractEntity.setUpdatedBy(connectedUser);
    }

    @PrePersist
    private void prePersistEntity(AbstractEntity abstractEntity){
        User connectedUser = connectedUserInformation.getConectedUser();
        abstractEntity.setCreatedAt(Instant.now());
        abstractEntity.setUpdatedBy(connectedUser);
    }
}
