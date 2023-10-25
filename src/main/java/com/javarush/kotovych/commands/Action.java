package com.javarush.kotovych.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public interface Action {
    void execute(BufferedReader reader, int key, BufferedWriter writer) throws IOException;
}
