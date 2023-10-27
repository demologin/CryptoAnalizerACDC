package com.javarush.kotovych.commands;

import com.javarush.kotovych.containers.Action;
import com.javarush.kotovych.containers.Alphabet;
import com.javarush.kotovych.exceptions.AppException;

import java.nio.file.Path;

public class Nothing implements Action {
    @Override
    public String execute(Path input, int key, Path output, Alphabet alphabet) {
        throw new AppException("Nothing");
    }
}
