package com.kouemo.studentservice.generics.exceptions.feature_exception;

import lombok.Data;
import lombok.Getter;
import org.hibernate.ObjectNotFoundException;

@Getter
public class UserNotFoundException extends ObjectNotFoundException {
    private final String message;

    public UserNotFoundException(Object identifier, String entityName,String message) {
        super(identifier, entityName);
        this.message = message;
    }

}
