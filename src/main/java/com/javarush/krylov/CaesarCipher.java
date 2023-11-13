package com.javarush.krylov;

public class CaesarCipher {
    public String encrypt(String message, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            int encryptedValue = (int) currentChar + key;
            encryptedText.append((char) encryptedValue);
        }
        return encryptedText.toString();
    }

    public String decrypt(String encryptedMessage, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentChar = encryptedMessage.charAt(i);
            int decryptedValue = (int) currentChar - key;
            decryptedText.append((char) decryptedValue);
        }
        return decryptedText.toString();
    }
}