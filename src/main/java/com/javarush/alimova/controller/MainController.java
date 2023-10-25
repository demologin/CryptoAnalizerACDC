package com.javarush.alimova.controller;

import com.javarush.alimova.commands.Command;

public class MainController {

    public static void giveCommand(String nameCommand, String[] args) {
        Command command = CommandContainer.getCommand(nameCommand);
        System.out.println(command);
    }
}
