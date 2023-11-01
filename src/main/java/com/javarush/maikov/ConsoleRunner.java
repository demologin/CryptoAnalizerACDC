package com.javarush.maikov;

import com.javarush.maikov.bruteforce.BruteForcer;
import com.javarush.maikov.constatns.Constants;
import com.javarush.maikov.decode.Decoder;
import com.javarush.maikov.encode.Encoder;

import java.util.Scanner;


public class ConsoleRunner {
    public static Scanner input = new Scanner(System.in);
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
                new Encoder();
                break;
            case 2:
                new Decoder();
                break;
            case 3:
                new BruteForcer();
                break;
            case 4:
                work = false;
            default:
                System.out.println("Пожалуйста, введите цифру нужного вам действия");
        }
    }
}









