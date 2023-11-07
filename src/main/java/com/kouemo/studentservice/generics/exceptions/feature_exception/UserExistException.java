package com.kouemo.studentservice.generics.exceptions.feature_exception;

import org.hibernate.NonUniqueObjectException;

public class UserExistException extends NonUniqueObjectException {
    public UserExistException(String message, String entityName) {
        super(message, entityName);
    }
}
