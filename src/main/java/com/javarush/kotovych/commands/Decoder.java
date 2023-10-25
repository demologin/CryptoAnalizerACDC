package com.javarush.kotovych.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Decoder extends CipherMethods implements Action{
    @Override
    public void execute(BufferedReader reader, int key, BufferedWriter writer) throws IOException {
        Action encoder = Actions.get("ENCODE");
        encoder.execute(reader, -key, writer);
    }
}
