package com.kouemo.studentservice.generics.exceptions.feature_exception;

import org.hibernate.NonUniqueObjectException;

public class SubjectExistException extends NonUniqueObjectException {
    public SubjectExistException(String message, String entityName) {
        super(message, entityName);
    }
}
