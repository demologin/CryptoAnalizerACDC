package com.javarush.levchuk.menu;

import com.javarush.levchuk.mods.BruteForce;
import com.javarush.levchuk.mods.Decode;
import com.javarush.levchuk.mods.Encode;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.ERROR_MESSAGES;
import static com.javarush.levchuk.constant.UtilConstants.TEXT_MAIN_MENU;
import static com.javarush.levchuk.menu.Runner.*;


public class MainMenu {
    public MainMenu() {
    }

    public void printMainMenu() {
        String input = "";
        do {
            try {
                System.out.println(TEXT_MAIN_MENU);
                Scanner scanner = new Scanner(System.in);
                 input = scanner.nextLine();
                switch (input) {
                    case "1" -> getEncode().runEncode();
                    case "2" -> getDecode().runDecode();
                    case "3" -> getBruteForce().runBruteForce();
                    case "4" -> System.out.println("Exit");
                    default -> System.err.println(ERROR_MESSAGES[1]);
                }
            } catch (InputMismatchException e){
                System.err.println(ERROR_MESSAGES[1]);
            }
        } while (!input.equals("4"));

    }

}



