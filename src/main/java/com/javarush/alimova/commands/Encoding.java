package com.javarush.alimova.commands;

import com.javarush.alimova.dictionary.Alphabet;

public class Encoding extends Coding{

    @Override
    protected int getIndex(int index, int key) {
        return (index + key) % Alphabet.CHARS.length;
    }
}
