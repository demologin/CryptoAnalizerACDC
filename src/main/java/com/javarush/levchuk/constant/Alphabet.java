package com.javarush.levchuk.constant;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private static final char[] ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е',
            'ё', 'ж', 'з', 'и', 'к', 'л',
            'м', 'н', 'о', 'п', 'р', 'с',
            'т', 'у', 'ф', 'х', 'ц', 'ч',
            'ш', 'щ', 'ъ', 'ы', 'ь', 'э',
            'я', '.', ',', '«', '»', '"',
            '\'', ':', '!', '?', ' ', '0',
            '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};
    public final static Map<Character, Integer> alphabetMap = new HashMap<>();
    ;

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            alphabetMap.put(ALPHABET[i], i);
        }
    }

    public static int getAlphabetSize() {
        return ALPHABET.length;
    }

    public static char getChar(int index) {
        return ALPHABET[index];
    }

    public static int getIndexByChar(char character) {

        return alphabetMap.get(character);
    }

}
