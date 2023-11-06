package com.javarush.boyarinov.constats;

import java.io.File;

public class Constant {

    private static final String RU = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String SYMBOL = ".,\"':;-!? \n";
    private static final String UNION = "что";
    private static final String PUNCTUATION = ", ";
    public static final String PUNCTUATION_RULE = PUNCTUATION + UNION;
    public static final char[] ALPHABET = (RU.toLowerCase() + SYMBOL).toCharArray();
    public static final String LOCATION_TXT = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    public static final int MAX_NUMBER_OF_SYMBOLS = 2500;

}
