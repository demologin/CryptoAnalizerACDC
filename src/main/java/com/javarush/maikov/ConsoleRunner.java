package com.javarush.maikov;

import java.util.Scanner;


public class ConsoleRunner {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(Constants.MENU);
        System.out.println("Введите ссылку на файл, который вы хотите расшифровать");
        String link = input.next();
        System.out.println("Введите ключ, для расшифровки");
        int key = input.nextInt();
        Decode decode = new Decode(link, key);



//        System.out.println("Введите ссылку на файл, который вы хотите зашифровать");
//        String link = input.next();
//        System.out.println("Введите ключ, которым вы хотите зашифровать файл");
//        int key = input.nextInt();
//        Encode encode = new Encode(link, key);

    }

}



