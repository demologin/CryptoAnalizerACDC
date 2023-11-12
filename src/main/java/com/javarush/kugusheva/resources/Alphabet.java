package com.javarush.kugusheva.resources;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    public static final String ALPHABET_LINE = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
    public static final String SYMBOLS_LINE = ".,”’:-!? ";

    public static final char[] CHAR_ARRAY = (ALPHABET_LINE.toLowerCase()+SYMBOLS_LINE).toCharArray();

    public static final Map<Character,Integer> ALPHABET_MAP = new HashMap<>();

    static {
        for (int i = 0; i < CHAR_ARRAY.length; i++) {
            ALPHABET_MAP.put(CHAR_ARRAY[i],i);
        }
    }
}
