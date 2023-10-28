package com.javarush.stukalov.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet {
    private static final String rus = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String symbols = "☮.,”’:-!? ";

    private static char[] CHARS = rus.toLowerCase().toCharArray();
    static {
        Arrays.sort(CHARS);
        String chars = String.valueOf(CHARS) + symbols;
        CHARS = chars.toCharArray();
    }

    public static char[] getCHARS() {
        return CHARS;
    }
    public static List<Character> getListOfCHARS() {
        List<Character> listOfCHARS = new ArrayList<>();
        for (Character character: CHARS) {
            listOfCHARS.add(character);
        }
        return listOfCHARS;
    }
}
