package com.ompany.exceptions;

public class AnswerNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 2;
    public AnswerNotFoundException(String message) {
        super(message);
    }
}
