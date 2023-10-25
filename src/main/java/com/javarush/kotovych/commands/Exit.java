package com.javarush.kotovych.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Exit implements Action{
    @Override
    public void execute(BufferedReader reader, int key, BufferedWriter writer) {
        throw new RuntimeException("Exit");
    }
}
