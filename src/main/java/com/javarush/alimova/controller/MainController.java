package com.javarush.alimova.controller;

import com.javarush.alimova.commands.Command;
import com.javarush.alimova.commands.Result;
import com.javarush.alimova.exception.AppException;

public class MainController {

    public static void giveCommand(String nameCommand, String[] args) {
        Command command = CommandContainer.getCommand(nameCommand);
        Result result;
        try {
            result = command.startCommand(args);
        }
        catch (AppException e) {
            result = new Result(false, e.getMessage());
        }

        System.out.println(resultCommand(result));
    }

    public static String resultCommand(Result result) {
        if (result.correctCommand && result.keyCoding != -1) {
            return "Operation completed successfully.\nInput file: " + result.inputFile +
                    "\nOutput file: " + result.outputFile +
                    "\nEncoding key: " + result.keyCoding;
        } else if (result.correctCommand) {
            return "Operation completed successfully.\nInput file: " + result.inputFile +
                    "\nOutput file: " + result.outputFile;
        }
        return "The operation failed with an error:\n" + result.message;
    }
}
