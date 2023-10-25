package com.javarush.kotovych.constants;

public class RuAlphabet {
    private static final String RU_ALPHABET = "абвгдеёжзийклмнопрстувхцчшщъыьэюя";
    public static final char[] CHARS = (RU_ALPHABET + OtherSymbols.NUMBERS + OtherSymbols.SYMBOLS).toCharArray();
}
