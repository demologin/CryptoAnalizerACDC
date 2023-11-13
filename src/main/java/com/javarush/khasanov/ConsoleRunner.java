package com.javarush.khasanov;

import com.javarush.khasanov.controller.MainController;
import com.javarush.khasanov.view.*;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        MainController mainController = new MainController();
        Application application = new Application(mainController, menu);
        application.run(args);
    }
}
