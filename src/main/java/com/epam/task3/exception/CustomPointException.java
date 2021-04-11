package com.epam.task3.exception;

public class CustomPointException extends Exception {
    public CustomPointException(){
    }
    public CustomPointException(String message){
        super(message);
    }
    public CustomPointException(Throwable cause){
        super(cause);
    }
    public CustomPointException(String message, Throwable cause){
        super(message, cause);
    }
}
