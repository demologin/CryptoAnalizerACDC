package Test.constant;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private static final String letters = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    private static final String cyphers = "1234567890";
    private static final String symbols = " .,/?'\":;[]{}\\|!@#$%^&*()~`";
    public static final char[] ALPHABET = (letters.toLowerCase()+cyphers+symbols).toCharArray();

    public static Map<Character, Integer> letterIndex = new HashMap<>();

    static{
        for (int i = 0; i < ALPHABET.length; i++) {
            letterIndex.put(ALPHABET[i], i);
        }
    }
}
