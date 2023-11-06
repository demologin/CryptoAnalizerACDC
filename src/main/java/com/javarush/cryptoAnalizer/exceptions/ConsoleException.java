package com.javarush.cryptoAnalizer.exceptions;

public class ConsoleException extends RuntimeException{
    public ConsoleException() {
    }

    public ConsoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsoleException(Throwable cause) {
        super(cause);
    }

    public ConsoleException(String message) {
        super(message);
    }
}
