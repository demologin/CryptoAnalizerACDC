package com.javarush.alimova;

import com.javarush.alimova.controller.MainController;
import com.javarush.alimova.view.console.ConsoleMenu;

public class ConsoleStarting {
    public static void main(String[] args) {

        MainController mainController = new MainController();
        ConsoleMenu consoleMenu = new ConsoleMenu(mainController);
        consoleMenu.startMenu();

    }
}
