package com.greatlearning.quora.error;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;
    private String debugMessage;

    public GenericException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public GenericException(String message, HttpStatus httpStatus, String eMessage) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.debugMessage = eMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
