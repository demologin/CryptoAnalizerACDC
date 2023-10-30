package com.javarush.zhukov.constant;

import java.util.HashMap;
import java.util.Map;

public class AlphaBet {
    private static final String en = "qwertyuiopasdfghjklzxcvbnm";
    private static final String rus = "йцукенгшщзхъэждлорпавыфячсмитьбю";
    private static final String symblos = ".,\"':;-?! ";
    private static final String numbers = "0123456789";
    public static final char[] arrayAlphaBet = (en + rus + numbers + symblos).toCharArray();
    public static Map<Character, Integer> alphaBet = new HashMap<>();

    static {
        for (int i = 0; i < arrayAlphaBet.length; i++) {
            alphaBet.put(arrayAlphaBet[i], i);
        }
    }

}

