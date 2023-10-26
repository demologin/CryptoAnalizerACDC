package com.javarush.kotovych.commands;

import java.nio.file.Path;

public class Decoder extends CipherMethods implements Action{
    @Override
    public String execute(Path input, int key, Path output){
        Action encoder = ActionContainer.get("ENCODE");
        return encoder.execute(input, -key, output);
    }

    public String decodeString(String text, int key){
        Encoder encoder = new Encoder();
        return encoder.encodeString(text, -key);
    }
}
