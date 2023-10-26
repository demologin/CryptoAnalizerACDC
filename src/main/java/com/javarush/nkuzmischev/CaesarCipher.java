package com.javarush.nkuzmischev;

import java.util.Scanner;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для шифрования: ");
        String plaintext = scanner.nextLine();
        System.out.print("Введите сдвиг: ");
        int shift = scanner.nextInt();

        char[] russianAlphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        String ciphertext = encrypt(plaintext, shift, russianAlphabet);
        System.out.println("Зашифрованный текст: " + ciphertext);

        String decryptedText = decrypt(ciphertext, shift, russianAlphabet);
        System.out.println("Расшифрованный текст: " + decryptedText);
    }

    public static String encrypt(String plaintext, int shift, char[] alphabet) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (Character.isLetter(currentChar)) {
                char encryptedChar = alphabet[(indexOf(alphabet, currentChar) + shift) % alphabet.length];
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(currentChar);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift, char[] alphabet) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            if (Character.isLetter(currentChar)) {
                char decryptedChar = alphabet[(indexOf(alphabet, currentChar) - shift + alphabet.length) % alphabet.length];
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(currentChar);
            }
        }
        return plaintext.toString();
    }

    public static int indexOf(char[] array, char element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
}


