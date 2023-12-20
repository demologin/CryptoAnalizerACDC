package com.javarush.Alymov.constant;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    private Alphabet() {
    }

    private static final String RUS_UPPER_CASE = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String RUS = "абвгдеёжзийклмнопрстуфхцчшщъыиэюя";
    private static final String ENG_UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ENG = "abcdefghijklmnopqrstuvwxyz";
    private static final String SYMBOLS = "\n @#$%^&*():;'\"<>,.!№|\\";
    private static final String NUMBERS = "1234567890";

    public static final char[] CHARS = ( RUS_UPPER_CASE + RUS + ENG_UPPER_CASE + ENG + SYMBOLS + NUMBERS).toCharArray();

    public final static Map<Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < CHARS.length; i++) {
            index.put(CHARS[i], i);
        }
    }
}
