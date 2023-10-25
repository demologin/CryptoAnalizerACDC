package com.javarush.alimova.commands;

import com.javarush.alimova.dictionary.Alphabet;

public class Decoding extends Coding{

    @Override
    protected int getIndex(int index, int key) {
        if (index - key < 0) {
            return Alphabet.CHARS.length + (index - key);
        }
        return index - key;
    }
}
