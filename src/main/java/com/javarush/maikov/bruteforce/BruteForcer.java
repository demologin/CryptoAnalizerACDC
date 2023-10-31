package com.javarush.maikov.bruteforce;

import com.javarush.maikov.decode.Decode;

import java.util.Scanner;

public class BruteForcer {
    public BruteForcer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите ссылку на файл, который вы хотите расшифровать Брутфорсом");
        String linkIn = input.next();
        System.out.println("Введите ссылку на файл или имя файла, в который вы хотите записать расшифрованный текст. " +
                "если файла с таким именем не существует, он будет создан.");
        String linkOut = input.next();
        BruteForce bruteForce = new BruteForce(linkIn, linkOut);
    }
}
