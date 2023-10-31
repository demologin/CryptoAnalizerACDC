package com.javarush.afanasenko;

public class CryptoException extends RuntimeException {
    public CryptoException(){
    }
    public CryptoException(String message){
        super(message);
    }

}
