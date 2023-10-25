package com.javarush.alimova.controller;

import com.javarush.alimova.commands.Command;
import com.javarush.alimova.commands.Result;

public class MainController {

    public static void giveCommand(String nameCommand, String[] args) {
        //на вход должен поступать только массив строк
        //подумать насчет static
        Command command = CommandContainer.getCommand(nameCommand);
        Result result = command.startCommand(args);
        System.out.println(resultCommand(result));

        //сюда должны прилетать все исключения, и здесь они должны обрабатываться
    }

    public static String resultCommand(Result result) {
        if (result == Result.OK) {
            return "Operation completed successfully";
        }
        return "Action error";
    }
}
