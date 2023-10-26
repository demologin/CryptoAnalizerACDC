package com.javarush.kotovych.commands;

import java.util.HashMap;
import java.util.Map;

public abstract class CipherMethods {
    public int findPosition(char[] chars, char symbol){
        for (int i = 0; i < chars.length; i++) {
            if(symbol == chars[i]){
                return i;
            }
        }
        return -1;
    }

    public int countChar(char[] chars, char ch){
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : chars) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        try {
            return charCount.get(ch);
        } catch (NullPointerException e){
            return 0;
        }

    }
}
