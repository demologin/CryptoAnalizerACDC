package com.javarush.shvetsov;

import java.util.Scanner;

public class isCorrectKeyClass {
    static int keyNumber;

    static void isCorrectKey(Scanner scanner) {
        do {
            System.out.println(Dialog.MESSAGEKEY);
            keyNumber = scanner.nextInt();
            if (keyNumber < 1 || keyNumber > Alphabet.ALPHABET.length - 1) {
                System.out.println(Dialog.MESSAGEUNCURRENTKEY);
            }
        }
        while (keyNumber < 1 || keyNumber > Alphabet.ALPHABET.length - 1);


    }
}

