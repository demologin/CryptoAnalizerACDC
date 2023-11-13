package com.javarush.KGurov.command;

import java.io.IOException;
import java.util.Scanner;

public class Encoder {

    public final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,! #$%^&*()_-+={}[}\\<> ";
    private int key;
    public static Encoder encode = new Encoder();

    public void Encoding() throws IOException {
        String frw = FileReaderWriter.fileReaderWriter.readFiles().toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Encoding...");
        for (int i = 0; i < frw.length(); i++) {
            if (ALPHABET.contains(frw.charAt(i) + "")) {
                char symbol = frw.charAt(i);
                int index = ALPHABET.indexOf(symbol) + this.key;
                if (index > ALPHABET.length() - 1) {
                    index -= ALPHABET.length();
                }
                stringBuilder.append(ALPHABET.charAt(index));
            } else if (frw.charAt(i) == '\n') {
                stringBuilder.append(frw.charAt(i));
            } else {
                stringBuilder.append(frw.charAt(i));
            }
        }
        System.out.println("Encoding completed!");
        FileReaderWriter.fileReaderWriter.writeFiles(stringBuilder.toString());
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