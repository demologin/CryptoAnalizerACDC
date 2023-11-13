package com.javarush.alimova.commands;

import com.javarush.alimova.controller.CommandContainer;
import com.javarush.alimova.dictionary.Alphabet;

import java.nio.file.Path;

public class Encoding extends Coding{

    @Override
    protected int getIndex(int index, int key) {
        return (index + key) % Alphabet.CHARS.length;
    }

    @Override
    protected Result getResult(Path inputFile, Path outputFile) {
        return new Result(true, CommandContainer.ENCODING, inputFile, outputFile);
    }
}
