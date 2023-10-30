package com.javarush.kotovych.constants;

import com.javarush.kotovych.containers.Alphabet;

import java.util.*;

public class EnAlphabet implements Alphabet {
    private final String EN_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String SYMBOLS = "`~!@#$%^&*(){}[]<>;:'\\|?., -_+\"";
    private final String SYMBOL_CHARS = (NUMBERS + SYMBOLS);
    private final char[] CHARS = (EN_ALPHABET + SYMBOL_CHARS).toCharArray();

    @Override
    public char[] getChars() {
        return CHARS;
    }


    public EnAlphabet(){
        Arrays.sort(CHARS);
    }
}
