package com.javarush.alimova.commands;

import com.javarush.alimova.controller.CommandContainer;
import java.nio.file.Path;

public class Result {

    public boolean correctCommand;
    public Path inputFile;
    public Path outputFile;

    public CommandContainer nameCommand;

    Result(boolean correctCommand, CommandContainer nameCommand, Path inputFile, Path outputFile) {
        this.correctCommand = correctCommand;
        this.nameCommand = nameCommand;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }
}
