package com.javarush.kudra;

public class UncorrectFileNameException extends RuntimeException{
    public UncorrectFileNameException() {
    }

    public UncorrectFileNameException(String message) {
        super(message);
    }

    public UncorrectFileNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncorrectFileNameException(Throwable cause) {
        super(cause);
    }
}
