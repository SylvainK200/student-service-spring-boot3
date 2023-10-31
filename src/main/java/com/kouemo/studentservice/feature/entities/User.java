package com.kouemo.studentservice.feature.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Table(name="feature_user")
@Entity
public class User extends AbstractEntity{
    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String emailAddress;
    private String password;

    private String address;
    private String name;
    private String phoneNumber;
    private double salary;

    @OneToMany(mappedBy = "professor")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "student")
    private List<Examination> examinations;
    @ManyToMany
    private List<Role> roles;

    @OneToMany(mappedBy = "professor")
    private List<Examination> examinationsByProfessor;

    private String firstname;
    private String lastname;
    private String serialNumber;

}
