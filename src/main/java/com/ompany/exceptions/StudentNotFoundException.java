package com.ompany.exceptions;

public class StudentNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 2;
    public StudentNotFoundException(String message) {
        super(message);
    }
}
