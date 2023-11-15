package com.javarush.kudra.constants;

public class Alphabet {
    private static final String rusLetters = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ";
    private static final String symbols = ",. :;!?\"\n";
    public static final char[]ALPHABET = (rusLetters+symbols).toLowerCase().toCharArray();

}
