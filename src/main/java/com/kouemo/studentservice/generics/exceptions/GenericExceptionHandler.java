package com.kouemo.studentservice.generics.exceptions;

import com.kouemo.studentservice.generics.exceptions.feature_exception.SubjectExistException;
import com.kouemo.studentservice.generics.exceptions.feature_exception.SubjectNotFoundException;
import com.kouemo.studentservice.generics.exceptions.feature_exception.UserExistException;
import com.kouemo.studentservice.generics.exceptions.feature_exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(userNotFoundException.getMessage());
    }

    @ExceptionHandler({SubjectNotFoundException.class})
    public ResponseEntity<Object> handleSubjectNotFoundException(SubjectNotFoundException subjectNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(subjectNotFoundException.getMessage());
    }

    @ExceptionHandler({UserExistException.class})
    public ResponseEntity<Object> handleUserExistException(UserExistException userExistException){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(userExistException.getMessage());
    }

    @ExceptionHandler({SubjectExistException.class})
    public ResponseEntity<Object> handleSubjectExistException(SubjectExistException subjectExistException){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(subjectExistException.getMessage());
    }
}
