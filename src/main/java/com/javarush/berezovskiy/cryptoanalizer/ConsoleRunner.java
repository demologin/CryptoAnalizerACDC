package com.javarush.berezovskiy.cryptoanalizer;

import com.javarush.berezovskiy.cryptoanalizer.controller.MainController;
import com.javarush.berezovskiy.cryptoanalizer.view.console.ConsoleApp;
import com.javarush.berezovskiy.cryptoanalizer.view.console.Menu;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        //build console app
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu(input);
        MainController mainController = new MainController();
        ConsoleApp application = new ConsoleApp(mainController, menu);
        //run console app
        application.run(args);
    }


}

