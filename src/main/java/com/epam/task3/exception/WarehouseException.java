package com.epam.task3.exception;

public class WarehouseException extends Exception {
    public WarehouseException() {
    }

    public WarehouseException(String message) {
        super(message);
    }

    public WarehouseException(Throwable cause) {
        super(cause);
    }

    public WarehouseException(String message, Throwable cause) {
        super(message, cause);
    }
}
