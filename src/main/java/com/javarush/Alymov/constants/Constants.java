package com.javarush.Alymov.constants;

import java.io.File;
import java.util.Locale;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String cypher = "0123456789";
    private static final String symbols = "!@#$%^&*()_+-=:;'\"{}[]<>,.?|№~";
    public static final String ALPHABET = rus + eng + rus.toLowerCase(Locale.ROOT) + eng.toLowerCase(Locale.ROOT) + cypher + symbols;
    public static final String TXT_FOLDER=System.getProperty("user.dir") + File.separator + "text" + File.separator;
}
