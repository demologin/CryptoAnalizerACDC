package com.javarush.kudra.constants;

import java.util.HashMap;

public class Alphabet {
    private static final String rusLetters = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ";
    private static final String symbols = ",. :;!?\"\n[]()<>-*%+/_";
    public static final char[]ALPHABET = (rusLetters+symbols).toLowerCase().toCharArray();

    public static final HashMap<Character,Integer> SYMBOLS_CHAR = new HashMap<>();
    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            SYMBOLS_CHAR.put(ALPHABET[i], i);
        }
    }
    public static final int SIZE = ALPHABET.length;


}
