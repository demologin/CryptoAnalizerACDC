package com.javarush.malyshev;

import java.io.IOException;
import java.util.Scanner;

public class EncryptAndDecrypt {

    public final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"':-!? ";
    private int key;
    public static EncryptAndDecrypt encryptAndDecrypt = new EncryptAndDecrypt();

    private EncryptAndDecrypt() {
    }

    public void Encryption() throws IOException {
        String rawText = ReadAndWrite.readAndWrite.readTheFile().toLowerCase();
        StringBuilder modifiedText = new StringBuilder();

        System.out.println("encrypting, encrypting, encrypting..");

        for (int i = 0; i < rawText.length(); i++) {
            if (ALPHABET.contains(rawText.charAt(i) + "")) {
                char symbol = rawText.charAt(i);
                int index = ALPHABET.indexOf(symbol) + this.key;
                if (index > ALPHABET.length() - 1) {
                    index -= ALPHABET.length();
                }
                modifiedText.append(ALPHABET.charAt(index));
            } else if (rawText.charAt(i) == '\n') {
                modifiedText.append(rawText.charAt(i));
            } else {
                modifiedText.append(rawText.charAt(i));
            }
        }

        System.out.println("Hooray! hooray! hooray! Encryption is complete!");

        ReadAndWrite.readAndWrite.writeTheFile(modifiedText.toString());
    }

    public void Decrypt() throws IOException {
        String encryptedText = ReadAndWrite.readAndWrite.readTheFile().toLowerCase().toLowerCase();
        StringBuilder decryptedText = new StringBuilder();

        System.out.println("deciphering, deciphering, deciphering..");

        for (int i = 0; i < encryptedText.length(); i++) {
            if (ALPHABET.contains(encryptedText.charAt(i) + "")) {
                char symbol = encryptedText.charAt(i);
                int index = ALPHABET.indexOf(symbol) - this.key;
                if (index < 0) {
                    index = ALPHABET.length() - Math.abs(index);
                }
                decryptedText.append(ALPHABET.charAt(index));
            } else if (encryptedText.charAt(i) == '\n') {
                decryptedText.append(encryptedText.charAt(i));
            } else {
                decryptedText.append(encryptedText.charAt(i));
            }
        }

        System.out.println("Hooray! hooray! hooray! Decryption is complete!");

        ReadAndWrite.readAndWrite.writeTheFile(decryptedText.toString());
    }

    public void EnterKey() {
        Scanner scanner = new Scanner(System.in);
        long key;

        while (true) {
            System.out.println("Enter key:");
            if (scanner.hasNextInt()) {
                key = scanner.nextInt() % 41;
                scanner.nextLine();

                this.key = (int) key;
                break;
            } else {
                System.out.println("Not a number, try again:");
                scanner.nextLine();
            }
        }
    }
    public void EnterKey (int key) {
        this.key = key;
    }
}
