package com.kouemo.studentservice.feature.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity {
    private Instant createdAt;
    private Instant updatedAt;
    private User createdBy;
    private User updatedBy;
}
