package com.javarush.alimova.dictionary;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    private Alphabet() {}

    private static final String rus = "йцукенгшщзхъфывапролджэячсмитьбю\n.,\"';-!? ";

    public static final char[] CHARS = rus.toLowerCase().toCharArray();

    public static final Map<Character, Integer> symbol = new HashMap<>();

    public static final int SIZE = CHARS.length;

    static {
        for (int i = 0; i < CHARS.length; i++) {
            symbol.put(CHARS[i], i);
        }
    }
}
