package com.micro.ratings.ExceptionHandler;

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException() {
    }

    public DuplicateUsernameException(String message) {
        super(message);
    }

    public DuplicateUsernameException(String message, Throwable cause) {
        super(message, cause);
    }
}
