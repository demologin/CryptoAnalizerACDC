package com.javarush.bogomolov.application;

import com.javarush.bogomolov.command.Cipher;
import com.javarush.bogomolov.exception.AppException;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    private int getOption(Scanner scanner) {
        int option;
        do {

            System.out.println(Messages.SELECT_OPTION);
            String choice = scanner.nextLine();
            option = switch (choice) {
                case "1" -> 0;
                case "2" -> 1;
                case "3" -> 2;

                default -> {
                    System.out.println(Messages.INCORRECT_OPTION);
                    yield -1;
                }
            };
        } while (option < 0);

        return option;
    }

    public void Action() {
        int option = getOption(scanner);
        Cipher cipher = new Cipher();
        if (option == 0) {
            try {
                Encode(cipher);

            } catch (AppException e) {
                System.out.println(Messages.ERROR);
            }


        } else if (option == 1) {
            try {
                Decode(cipher);

            } catch (AppException e) {
                System.out.println(Messages.ERROR);

            }

        } else if (option == 2) {
            System.out.println(Messages.APPLICATION_CLOSED);
        }


    }

    private void Decode(Cipher cipher) {
        String destFile;
        String sourceFile;
        int key;
        System.out.println(Messages.CHOOSE_FILE);
        sourceFile = scanner.nextLine();
        System.out.println(Messages.DESTINATION_PATH);
        destFile = scanner.nextLine();
        System.out.println(Messages.KEY);
        key = scanner.nextInt();
        cipher.decrypt(sourceFile, destFile, key);
        System.out.println(Messages.FILE_DECRYPTED);
    }

    private void Encode(Cipher cipher) {
        String destFile;
        int key;
        String sourceFile;
        System.out.println(Messages.CHOOSE_FILE);
        sourceFile = scanner.nextLine();
        System.out.println(Messages.DESTINATION_PATH);
        destFile = scanner.nextLine();
        System.out.println(Messages.KEY);
        key = scanner.nextInt();
        cipher.encrypt(sourceFile, destFile, key);
        System.out.println(Messages.FILE_ENCRYPTED);
    }


}

