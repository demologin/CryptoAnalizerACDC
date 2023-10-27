package com.javarush.kotovych.commands;

import com.javarush.kotovych.containers.Action;
import com.javarush.kotovych.containers.ActionContainer;
import com.javarush.kotovych.containers.Alphabet;

import java.nio.file.Path;

public class Decoder extends CipherMethods implements Action {
    @Override
    public String execute(Path input, int key, Path output, Alphabet alphabet){
        Action encoder = ActionContainer.get("ENCODE");
        return encoder.execute(input, -key, output, alphabet);
    }

    public String decodeString(String text, int key, Alphabet alphabet){
        Encoder encoder = new Encoder();
        return encoder.encodeString(text, -key, alphabet);
    }
}
