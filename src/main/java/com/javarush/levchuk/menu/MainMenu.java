package com.javarush.levchuk.menu;

import com.javarush.levchuk.mods.BruteForce;
import com.javarush.levchuk.mods.Decode;
import com.javarush.levchuk.mods.Encode;

import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.TEXT_MAIN_MENU;


public class MainMenu {
    public MainMenu() {
    }

    public void printMainMenu() {
        String input;
        do {
            try {
                System.out.println(TEXT_MAIN_MENU);
                Scanner scanner = new Scanner(System.in);
                 input = scanner.nextLine();
                switch (input) {
                    case "1" -> new Encode();
                    case "2" -> new Decode();
                    case "3" -> new BruteForce();
                    case "4" -> System.out.println("Exit");
                    default -> System.out.println("Incorrect selection. Choose a number from 1 to 4");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (!input.equals("4"));
    }

}



