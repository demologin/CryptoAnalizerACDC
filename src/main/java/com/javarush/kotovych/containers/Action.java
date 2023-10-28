package com.javarush.kotovych.containers;

import java.nio.file.Path;

public interface Action {
    String execute(Path input, int key, Path output, Alphabet alphabet);
}
