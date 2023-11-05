package com.kouemo.studentservice.feature.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Table(name="feature_user")
@Entity
public class User extends AbstractEntity implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getKey())).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
