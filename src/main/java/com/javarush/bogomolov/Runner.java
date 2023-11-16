package com.javarush.bogomolov;


import com.javarush.bogomolov.application.Menu;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.Action();


    }
}
