package com.javarush.alimova.controller;

import com.javarush.alimova.commands.Command;

public class MainController {

    public static void giveCommand(String nameCommand, String[] args) {
        //на вход должен поступать только массив строк
        Command command = CommandContainer.getCommand(nameCommand);
        command.startCommand(args);
    }
}
