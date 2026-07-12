package com.sakr.bookstore.exception.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}