package com.javarush.bogomolov.application;

import com.javarush.bogomolov.command.Cipher;
import com.javarush.bogomolov.exception.AppException;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getOption(Scanner scanner) {
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
        int key;
        String sourceFile;
        String destFile;
        if (option == 0) {
            try {
                System.out.println(Messages.CHOOSE_FILE);
                sourceFile = scanner.nextLine();
                System.out.println(Messages.DESTINATION_PATH);
                destFile = scanner.nextLine();
                System.out.println(Messages.KEY);
                key = scanner.nextInt();
                cipher.encrypt(sourceFile, destFile, key);
                System.out.println(Messages.FILE_ENCRYPTED);

            } catch (Exception e) {
                throw new AppException(Messages.ERROR);
            }


        } else if (option == 1) {
            try {
                System.out.println(Messages.CHOOSE_FILE);
                sourceFile = scanner.nextLine();
                System.out.println(Messages.DESTINATION_PATH);
                destFile = scanner.nextLine();
                System.out.println(Messages.KEY);
                key = scanner.nextInt();
                cipher.decrypt(sourceFile, destFile, key);
                System.out.println(Messages.FILE_DECRYPTED);

            } catch (Exception e) {
                throw new AppException(Messages.ERROR);

            }

        } else if (option == 2) {
            System.out.println(Messages.APPLICATION_CLOSED);
        }


    }


}

