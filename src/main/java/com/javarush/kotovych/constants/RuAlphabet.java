package com.javarush.kotovych.constants;

import com.javarush.kotovych.containers.Alphabet;

import java.util.*;

public class RuAlphabet implements Alphabet {
    private final String RU_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final String NUMBERS = "0123456789";
    private final String SYMBOLS = "`~!@#$%^&*(){}[]<>;:'\\|?., -_+\"";
    private final String SYMBOL_CHARS = (NUMBERS + SYMBOLS);
    private final char[] CHARS = (RU_ALPHABET + SYMBOL_CHARS).toCharArray();

    @Override
    public char[] getChars() {
        return CHARS;
    }


    public RuAlphabet(){
        Arrays.sort(CHARS);
    }
}
