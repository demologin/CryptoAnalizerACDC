package com.javarush.kotovych.containers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;

public interface Action {
    String execute(Path input, int key, Path output, Alphabet alphabet);
}
