package com.javarush.kotovych.commands;

import com.javarush.kotovych.containers.Action;
import com.javarush.kotovych.containers.Alphabet;

import java.nio.file.Path;

public class Decoder extends Encoder implements Action {
    @Override
    public String execute(Path input, int key, Path output, Alphabet alphabet){
        return super.execute(input, -key, output, alphabet);
    }

    public String decodeString(String text, int key, Alphabet alphabet){
        return super.encodeString(text, -key, alphabet);
    }
}
