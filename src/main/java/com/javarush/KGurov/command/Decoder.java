package com.javarush.KGurov.command;

import java.io.IOException;
import java.util.Scanner;

public class Decoder {

    public final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,! #$%^&*()_-+={}[}\\<> ";
    private int key;
    public static Decoder decode = new Decoder();

    private Decoder() {
    }

    public void Decoding() {
        String encryptedText = null;
        try {
            encryptedText = FileReaderWriter.fileReaderWriter.readFiles().toLowerCase().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder decryptedText = new StringBuilder();
        System.out.println("Decoding...");
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
        System.out.println("Decoding complited!");
        try {
            FileReaderWriter.fileReaderWriter.writeFiles(decryptedText.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void EnterKey() {
        Scanner scanner = new Scanner(System.in);
        long key;

        while (true) {
            System.out.println("Enter key:");
            if (scanner.hasNextInt()) {
                key = scanner.nextInt() % ALPHABET.length();
                scanner.nextLine();
                this.key = (int) key;
                break;
            } else {
                System.out.println("Try again:");
                scanner.nextLine();
            }
        }
    }
}
