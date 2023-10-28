package com.javarush.levchuk;

import com.javarush.levchuk.mods.Analyze;
import com.javarush.levchuk.mods.BruteForce;
import com.javarush.levchuk.mods.Decode;
import com.javarush.levchuk.mods.Encode;

import java.util.Scanner;


public class MainMenu {
    private final static String TEXT_MAIN_MENU = "\nPlease select mode:\n" +
            "1. Encrypt\n" +
            "2. Decrypt\n" +
            "3. Brute force\n" +
            "4. Analyze\n" +
            "5. Exit\n";


    public MainMenu() {
        System.out.println(TEXT_MAIN_MENU);
    }
    public void selectNumberMode(Scanner enter){
        String input=enter.nextLine();
        switch (input){
            case "1" -> new Encode();
            case "2" -> new Decode();
            case "3" -> new BruteForce();
            case "4" -> new Analyze();
            case "5" -> System.out.println("Exit");
            default -> System.out.println("INCORRECT_SELECTION");
            }

        }

    }

