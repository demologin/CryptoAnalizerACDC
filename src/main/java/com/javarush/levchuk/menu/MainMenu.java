package com.javarush.levchuk.menu;

import com.javarush.levchuk.mods.Analyze;
import com.javarush.levchuk.mods.BruteForce;
import com.javarush.levchuk.mods.Decode;
import com.javarush.levchuk.mods.Encode;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.TEXT_MAIN_MENU;


public class MainMenu {
    public MainMenu() {
    }

    public void printMainMenu() {
        int input = 0;
        do {
            try {
                System.out.println(TEXT_MAIN_MENU);
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                switch (input) {
                    case 1 -> new Encode();
                    case 2 -> new Decode();
                    case 3 -> new BruteForce();
                    case 4 -> new Analyze();
                    case 5 -> System.out.println("Exit");
                    default -> System.err.println("Incorrect selection");
                }
            } catch (InputMismatchException e){
                System.err.println("Please enter a numeric value");
            }
        } while (input != 5);

    }

}



