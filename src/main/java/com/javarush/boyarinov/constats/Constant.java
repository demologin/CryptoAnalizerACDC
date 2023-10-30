package com.javarush.boyarinov.constats;

import java.io.File;

public class Constant {

    private static final String RU = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String SYMBOL = ".,\"':;-!? ";
    public static final char[] ALPHABET = (RU.toLowerCase() + SYMBOL).toCharArray();
    public static final String LOCATION_TXT = System.getProperty("user.dir") + File.separator + "text" + File.separator;

}
