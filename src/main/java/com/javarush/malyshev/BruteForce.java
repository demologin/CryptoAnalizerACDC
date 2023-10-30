package com.javarush.malyshev;

import java.io.IOException;


public class BruteForce {
    public static BruteForce bruteForce = new BruteForce();

    private BruteForce() {
    }

    public void bruteForce() throws IOException {
        String encryptedText = ReadAndWrite.readAndWrite.readTheFile().toLowerCase();
        StringBuilder decryptedText = new StringBuilder();
        int countOfSpaces = 0;
        int correctKey = 0;

        for (int key = 0; key < EncryptAndDecrypt.encryptAndDecrypt.ALPHABET.length(); key++) {
            for (int j = 0; j < encryptedText.length(); j++) {
                if (EncryptAndDecrypt.encryptAndDecrypt.ALPHABET.contains(encryptedText.charAt(j) + "")) {
                    char symbol = encryptedText.charAt(j);
                    int index = EncryptAndDecrypt.encryptAndDecrypt.ALPHABET.indexOf(symbol) - key;
                    if (index < 0) {
                        index = EncryptAndDecrypt.encryptAndDecrypt.ALPHABET.length() - Math.abs(index);
                    }
                    decryptedText.append(EncryptAndDecrypt.encryptAndDecrypt.ALPHABET.charAt(index));
                } else if (encryptedText.charAt(j) == '\n') {
                    decryptedText.append(encryptedText.charAt(j));
                } else {
                    decryptedText.append(encryptedText.charAt(j));
                }
            }
            int currentSpaces = 0;
            for (int i = 0; i < decryptedText.length(); i++) {
                if (decryptedText.charAt(i) == 32) {
                    currentSpaces++;

                }
                if (i == decryptedText.length() - 1) {
                    if (currentSpaces > countOfSpaces) {
                        countOfSpaces = currentSpaces;
                        correctKey = key;
                    }
                    currentSpaces = 0;
                    decryptedText = new StringBuilder();
                }
            }


        }
        System.out.println("Correct key: " + correctKey);
        EncryptAndDecrypt.encryptAndDecrypt.EnterKey(correctKey);
        EncryptAndDecrypt.encryptAndDecrypt.Decrypt();
    }
}
