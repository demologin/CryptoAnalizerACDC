package com.javarush.alimova.commands;

import com.javarush.alimova.controller.CommandContainer;
import com.javarush.alimova.dictionary.Alphabet;

import java.nio.file.Path;

public class Decoding extends Coding{

    @Override
    protected int getIndex(int index, int key) {
        if (index - key < 0) {
            return Alphabet.CHARS.length + (index - key);
        }
        return index - key;
    }
    @Override
    protected Result getResult(Path inputFile, Path outputFile) {
        return new Result(true, CommandContainer.DECODING, inputFile, outputFile);
    }
}
