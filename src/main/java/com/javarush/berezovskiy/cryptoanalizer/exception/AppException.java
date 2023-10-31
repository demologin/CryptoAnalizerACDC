package com.javarush.berezovskiy.cryptoanalizer.exception;

public class AppException extends RuntimeException{

    public AppException() {
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(String message) {
        super(message);
    }
}
