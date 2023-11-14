package com.javarush.khmelov.constant;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    private Alphabet() {
    }

    private static final String RUS = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String SYMBOLS = "\n☮.,”’:-!? ";

    public static final char[] charsArray = (RUS.toLowerCase() + SYMBOLS).toCharArray();

    public final static Map<Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < charsArray.length; i++) {
            index.put(charsArray[i], i);
        }
    }
}
