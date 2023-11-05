package com.kouemo.studentservice.generics.enums;

import org.springframework.security.core.parameters.P;

public enum RoleEnum {
    SUPER_USER("SUPER_USER","ROLE D'ADMINISTRATION SUR TOUTES LES RESSOURCES"),
    STUDENT("STUDENT","ROLE ETUDIANT"),
    PROFESSOR("PROFESSOR","ROLE PROFESSEUR")
    ;

    private String key;
    private String description;

    public String getKey() {
        return key;
    }

    RoleEnum(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

