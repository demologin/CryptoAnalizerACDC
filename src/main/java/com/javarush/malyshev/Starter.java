package com.javarush.malyshev;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                --------------------
                Please select mode:
                1. Encrypt
                2. Decrypt
                3. Brute force
                4. Analyze
                5. Exit
                --------------------
                """);

        try {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                Choice.makeStartingChoice(number);
            } else {
                System.out.println("Please enter a number:");
                scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.printf("The exception %s was successfully eaten;)%n", e);
            System.out.println("But here's a stack trace, if you want " + "¯\\_(ツ)_/¯");
            e.printStackTrace();
        }
    }
}
