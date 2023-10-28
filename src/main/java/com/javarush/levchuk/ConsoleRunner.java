package com.javarush.levchuk;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        mainMenu.selectNumberMode(enter);
    }
}

