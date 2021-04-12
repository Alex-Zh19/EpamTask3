package com.epam.task3.exception;

public class CubeException extends Exception {
    public CubeException() {
    }

    public CubeException(String message) {
        super(message);
    }

    public CubeException(Throwable cause) {
        super(cause);
    }

    public CubeException(String message, Throwable cause) {
        super(message, cause);
    }
}
