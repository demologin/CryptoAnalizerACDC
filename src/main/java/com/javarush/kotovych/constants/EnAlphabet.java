package com.javarush.kotovych.constants;

public class EnAlphabet {
    private static final String EN_ALPHABET = "abcdefghijklmnopqrstuvwqyz";
    public static final char[] CHARS = (EN_ALPHABET + OtherSymbols.NUMBERS + OtherSymbols.SYMBOLS).toCharArray();
}
