package com.javarush.stukalov.exceptions;

public class TryAgainException extends RuntimeException {
    public TryAgainException() {
    }

    public TryAgainException(String message) {
        super(message);
    }

    public TryAgainException(String message, Throwable cause) {
        super(message, cause);
    }

    public TryAgainException(Throwable cause) {
        super(cause);
    }

    public TryAgainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
