package com.javarush.kotovych.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class CipherMethods {
    public int findPosition(char[] chars, char symbol){
        return Arrays.binarySearch(chars, symbol);
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

    public char mostFrequentChar(char[] chars){
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : chars) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        char mostRepeated = 0;
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostRepeated = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostRepeated;
    }
}
