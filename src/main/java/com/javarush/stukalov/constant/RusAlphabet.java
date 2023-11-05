package com.javarush.stukalov.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RusAlphabet {
    private static final String LETTERS = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String SYMBOLS = "☮.,”’:-!? ";

    private static char[] CHARS = LETTERS.toLowerCase().toCharArray();
    static {
        Arrays.sort(CHARS);
        String chars = String.valueOf(CHARS) + SYMBOLS;
        CHARS = chars.toCharArray();
    }

    public static char[] getCHARS() {
        return CHARS;
    }
    public static List<Character> getAlphabet() {
        List<Character> listOfCHARS = new ArrayList<>();
        for (Character character: CHARS) {
            listOfCHARS.add(character);
        }
        return listOfCHARS;
    }
}
