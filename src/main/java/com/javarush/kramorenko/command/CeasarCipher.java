package com.javarush.kramorenko.command;

import com.javarush.kramorenko.constants.Alphabet;

import java.util.Scanner;



public class CeasarCipher {
    public String encryptText(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encryptedText.append(encryptChar(c, key));
        }
        return encryptedText.toString();
    }
    private static char encryptChar(char c, int key) {
        int index = Alphabet.ALPHABET.indexOf(c);
        if (index != -1) {
            int shiftedIndex = (index + key) % Alphabet.ALPHABET.length();
            return Alphabet.ALPHABET.charAt(shiftedIndex);
        }
        return c;
    }

    public String decryptText(String text, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            decryptedText.append(decryptChar(c, key));
        }
        return decryptedText.toString();
    }

    private static char decryptChar(char c, int key) {
        int index = Alphabet.ALPHABET.indexOf(c);
        if (index != -1) {
            int shiftedIndex = (index - key + Alphabet.ALPHABET.length()) % Alphabet.ALPHABET.length();
            return Alphabet.ALPHABET.charAt(shiftedIndex);
        }
        return c;
    }
}
