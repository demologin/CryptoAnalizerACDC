package com.javarush.kotovych.constants;

import com.javarush.kotovych.containers.Alphabet;
import com.javarush.kotovych.exceptions.AppException;

import java.util.List;

public class NoAlphabet implements Alphabet {
    @Override
    public char[] getChars() {
        throw new AppException("No alphabet");
    }

    @Override
    public List<String> getWords() {
        throw new AppException("No words in no alphabet");
    }
}
