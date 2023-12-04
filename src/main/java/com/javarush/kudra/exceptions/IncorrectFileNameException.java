package com.javarush.kudra.exceptions;

public class IncorrectFileNameException extends RuntimeException{
    public IncorrectFileNameException() {
    }

    public IncorrectFileNameException(String message) {
        super(message);
    }

    public IncorrectFileNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectFileNameException(Throwable cause) {
        super(cause);
    }
}
