package com.javarush.bogomolov;

import com.javarush.bogomolov.command.Cipher;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Cipher cipher =new Cipher();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь");
        String string = scanner.nextLine();
        System.out.println("Введите ключ");
        int key = scanner.nextInt();
        String string1 = "C:\\test\\test2.txt";
        String string2 = "C:\\test\\test3.txt";
        cipher.encrypt(string,string1,key);
        cipher.decrypt(string1,string2,key);



    }
}
