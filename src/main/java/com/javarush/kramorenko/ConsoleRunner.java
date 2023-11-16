package com.javarush.kramorenko;


import com.javarush.kramorenko.viewConsole.Menu;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.runApplication();

    }
}
