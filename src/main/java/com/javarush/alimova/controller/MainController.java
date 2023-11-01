package com.javarush.alimova.controller;

import com.javarush.alimova.commands.Command;
import com.javarush.alimova.commands.Result;
import com.javarush.alimova.exception.AppException;

public class MainController {

    public Result giveCommand(String nameCommand, String[] args) {
        Result result;
        try {
            Command command = CommandContainer.getCommand(nameCommand);
            result = command.startCommand(args);
        }
        catch (AppException e) {
            result = new Result(false, e.getMessage());
        }
        return result;
    }

    public void printResultCommand(Result result) {
        if (result.correctCommand && result.keyCoding != -1) {
            System.out.println("Operation completed successfully.\nInput file: " + result.inputFile +
                    "\nOutput file: " + result.outputFile +
                    "\nEncoding key: " + result.keyCoding);
        } else if (result.correctCommand) {
            System.out.println("Operation completed successfully.\nInput file: " + result.inputFile +
                    "\nOutput file: " + result.outputFile);
        } else {
            System.out.println("The operation failed with an error:\n" + result.message);
        }

    }
}
