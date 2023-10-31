package com.kouemo.studentservice.feature.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder

public class Subject extends AbstractEntity{


    private String name;
    private String objectives;
    private long credit;

    @ManyToOne(fetch = FetchType.LAZY)
    private User professor;


}
