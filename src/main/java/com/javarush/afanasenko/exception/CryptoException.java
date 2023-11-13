package com.javarush.afanasenko.exception;

public class CryptoException extends RuntimeException {
    public CryptoException() {
    }

    public CryptoException(String message) {
        super(message);
    }
}
