package com.javarush.alimova.controller;

import com.javarush.alimova.commands.Command;
import com.javarush.alimova.commands.Decoding;
import com.javarush.alimova.commands.Encoding;
import com.javarush.alimova.exception.AppException;

public enum CommandContainer {

    ENCODING(new Encoding()),

    DECODING(new Decoding());

    public static final String[] commandSet = {"Encoding", "Decoding", "Exist"};
    private final Command command;

    CommandContainer(Command command) {
        this.command = command;
    }

    public static Command getCommand(String commandName) {
        try {
            CommandContainer instance = CommandContainer.valueOf(commandName.toUpperCase());
            return instance.command;
        } catch (IllegalArgumentException e) {
            System.out.println("Невалидное наименование");
            throw new AppException();
        }
    }


//    public static Command getCommand(CommandContainer value) {
//        try {
            //CommandContainer instance = CommandContainer.valueOf(commandName.toUpperCase());
//
//        } catch (IllegalArgumentException e) {
//            System.out.println("Невалидное наименование");
//            throw new AppException();
//        }
//    }

}
