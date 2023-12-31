package com.kouemo.studentservice.feature.entities;

import com.kouemo.studentservice.generics.enums.EnumSession;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Examination extends AbstractEntity{

    @Max(20)
    @Min(0)
    private double rating;
    @Enumerated(EnumType.STRING)
    private EnumSession session;


    private Instant dateExamination;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    private User professor;

    @ManyToOne(fetch = FetchType.LAZY)
    private User student;

}
