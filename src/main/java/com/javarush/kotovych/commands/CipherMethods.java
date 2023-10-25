package com.javarush.kotovych.commands;


public abstract class CipherMethods {
    public int findPosition(char[] chars, char symbol){
        for (int i = 0; i < chars.length; i++) {
            if(symbol == chars[i]){
                return i;
            }
        }
        return -1;
    }

    public boolean isRussianLetter(char c) {
        return Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC;
    }

    public boolean isEnglishLetter(char c) {
        return Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BASIC_LATIN;
    }
}
