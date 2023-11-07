package com.kouemo.studentservice.generics.exceptions.feature_exception;

import lombok.Getter;
import org.hibernate.ObjectNotFoundException;

@Getter
public class SubjectNotFoundException extends ObjectNotFoundException {
    private final String message;
    public SubjectNotFoundException(Object identifier, String entityName, String message) {
        super(identifier, entityName);
        this.message = message;
    }
}
