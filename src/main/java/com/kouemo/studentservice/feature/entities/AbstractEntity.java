package com.kouemo.studentservice.feature.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractEntity {
    private Instant createdAt;
    private Instant updatedAt;

    @OneToOne
    private User createdBy;

    @OneToOne
    private User updatedBy;
}
