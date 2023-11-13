package com.javarush.krylov.src;

import Service.FileSaver;
import Service.TextFromFileLoader;

import java.util.Scanner;

public class UI {

    private final CaesarCipher cc = new CaesarCipher();
    private final BruteForceCipher bfc = new BruteForceCipher();
    private final Scanner sc = new Scanner(System.in);
    private final TextFromFileLoader reader = new TextFromFileLoader();
    private final FileSaver writer = new FileSaver();

    public void start() {
        int choice;
        while (true) {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    String inputPath = getInputPath();
                    String text = reader.getText(inputPath);
                    String outputPath = getOutputPath();
                    int key = getKey();
                    String encryptedText = cc.encrypt(text, key);
                    writer.saveText(encryptedText, outputPath);
                }
                case 2 -> {
                    String inputPath = getInputPath();
                    String text = reader.getText(inputPath);
                    String outputPath = getOutputPath();
                    int key = getKey();
                    String decryptedText = cc.decrypt(text, key);
                    writer.saveText(decryptedText, outputPath);
                }
                case 3 -> {
                    String inputPath = getInputPath();
                    String text = reader.getText(inputPath);
                    String forceDecryptedText = bfc.simpleDecryption(text);
                    String outputPath = getOutputPath();
                    writer.saveText(forceDecryptedText, outputPath);
                }
                case 4 -> {
                    String inputPath = getInputPath();
                    String text = reader.getText(inputPath);
                    String forceDecryptedText = bfc.noSpecCharsDecryption(text);
                    String outputPath = getOutputPath();
                    writer.saveText(forceDecryptedText, outputPath);
                }
                case 5 -> {
                    String inputPath = getInputPath();
                    String text = reader.getText(inputPath);
                    String forceDecryptedText = bfc.smallTextDecryption(text);
                    String outputPath = getOutputPath();
                    writer.saveText(forceDecryptedText, outputPath);
                }
                case 6 -> {
                    System.out.println("Good Bye!");
                    return;
                }
                default -> System.out.println("Wrong value entered, try again");
            }
        }
    }
    private void displayMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Encrypt text");
        System.out.println("2. Decrypt text");
        System.out.println("3. Brute Force decryption");
        System.out.println("4. Brute Force decryption for text without special chars");
        System.out.println("5. Brute Force decryption for text smaller than 50 symbols without special chars");
        System.out.println("6. Exit");
    }

    private String getInputPath() {
        System.out.println("Please enter a path to input file:");
        return sc.nextLine();
    }

    private String getOutputPath() {
        System.out.println("Please enter a path to output file:");
        return sc.nextLine();
    }

    private int getKey() {
        System.out.println("Please enter a key value:");
        return sc.nextInt();
    }
}