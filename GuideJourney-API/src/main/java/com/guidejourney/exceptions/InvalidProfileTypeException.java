package com.guidejourney.exceptions;

public class InvalidProfileTypeException extends RuntimeException {
    public InvalidProfileTypeException(String message) {
        super(message);
    }
}
