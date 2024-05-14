package com.ompany.exceptions;

public class ChannelNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 2;
    public ChannelNotFoundException(String message) {
        super(message);
    }
}
