package com.javarush.alimova.commands;

import com.javarush.alimova.controller.CommandContainer;
import java.nio.file.Path;

public class Result {

    public boolean correctCommand;
    public Path inputFile;
    public Path outputFile;

    public int keyCoding = -1;

    public String message = null;

    public CommandContainer nameCommand;

    public Result(boolean correctCommand, String message) {
        this.correctCommand = correctCommand;
        this.message = message;
    }

    public Result(boolean correctCommand, CommandContainer nameCommand, Path inputFile, Path outputFile) {
        this.correctCommand = correctCommand;
        this.nameCommand = nameCommand;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public Result(boolean correctCommand, CommandContainer nameCommand, Path inputFile, Path outputFile, int keyCoding) {
        this.correctCommand = correctCommand;
        this.nameCommand = nameCommand;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.keyCoding = keyCoding;
    }
}
