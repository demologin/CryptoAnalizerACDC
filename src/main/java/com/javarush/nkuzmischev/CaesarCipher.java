package com.javarush.nkuzmischev;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для шифрования: ");
        String plaintext = scanner.nextLine();
        System.out.print("Введите сдвиг: ");
        int shift = scanner.nextInt();

        String ciphertext = encrypt(plaintext, shift);
        System.out.println("Зашифрованный текст: " + ciphertext);

        String decryptedText = decrypt(ciphertext, shift);
        System.out.println("Расшифрованный текст: " + decryptedText);
    }

    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) (((currentChar - 'a' + shift) % 26) + 'a');
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(currentChar);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            if (Character.isLetter(currentChar)) {
                char decryptedChar = (char) (((currentChar - 'a' - shift + 26) % 26) + 'a');
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(currentChar);
            }
        }
        return plaintext.toString();
    }
}

