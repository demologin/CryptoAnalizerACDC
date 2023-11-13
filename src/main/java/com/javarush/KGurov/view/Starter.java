package com.javarush.KGurov.view;

import com.javarush.KGurov.command.Cases;

import java.io.IOException;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "--------------------\n" +
                        "Please select mode:\n" +
                        "1. Encoding\n" +
                        "2. Decoding\n" +
                        "3. Exit\n" +
                        "--------------------\n");
        try {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                Cases.cases(number);
            } else {
                System.out.println("Please enter a number:");
                scanner.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
