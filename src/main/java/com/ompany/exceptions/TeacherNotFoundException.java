package com.ompany.exceptions;

public class TeacherNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public TeacherNotFoundException(String message) {
        super(message);
    }
}
