package com.javarush.maikov;

import java.util.Scanner;


public class ConsoleRunner {
    static Scanner input = new Scanner(System.in);
    static Boolean work = true;

    public static void main(String[] args) {

        while (work) {
            System.out.println(Constants.MENU);
            switchMenu(Integer.parseInt(input.next()));
        }
    }

    private static void switchMenu(int choice) {
        switch (choice) {
            case 1:
                encoder();
                break;
            case 2:
                decoder();
                break;
            case 3:
                work = false;
            default:
                System.out.println("Пожалуйста, введите цифру нужного вам действия");
        }

    }

    private static void encoder() {
        System.out.println("Введите ссылку на файл, который вы хотите зашифровать");
        String linkIn = input.next();
        System.out.println("Введите ссылку на файл или имя файла, в который вы хотите записать зашифрованнй текст. " +
                "если файла с таким именем не существует, он будет создан");
        String linkOut = input.next();
        System.out.println("Введите ключ, которым вы хотите зашифровать файл");
        int key = Integer.parseInt(input.next());
        Encode encode = new Encode(linkIn, linkOut, key);
    }

    private static void decoder() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите ссылку на файл, который вы хотите расшифровать");
        String linkIn = input.next();
        System.out.println("Введите ссылку на файл или имя файла, в который вы хотите записать расшифрованный текст. " +
                "если файла с таким именем не существует, он будет создан");
        String linkOut = input.next();
        System.out.println("Введите ключ, для расшифровки");
        int key = input.nextInt();
        Decode decode = new Decode(linkIn, linkOut, key);
    }
}









