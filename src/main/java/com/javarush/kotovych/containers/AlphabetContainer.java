package com.javarush.kotovych.containers;

import com.javarush.kotovych.constants.Constants;
import com.javarush.kotovych.constants.EnAlphabet;
import com.javarush.kotovych.constants.NoAlphabet;
import com.javarush.kotovych.constants.RuAlphabet;

public enum AlphabetContainer {
    RU_ALPHABET(new RuAlphabet()),
    EN_ALPHABET(new EnAlphabet()),
    NO_ALPHABET(new NoAlphabet()),
    ;

    private final Alphabet alphabet;

     AlphabetContainer(Alphabet alphabet){
        this.alphabet = alphabet;
    }

    public static Alphabet get(String alphabetName){
        return switch (alphabetName){
            case Constants.RU -> RU_ALPHABET.alphabet;
            case Constants.EN -> EN_ALPHABET.alphabet;
            default -> NO_ALPHABET.alphabet;
        };
    }
}
