package com.javarush.berezovskiy.constant;

import java.io.File;

public class Constant {

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator+"text"+File.separator;
    public static final String EMPTY_STRING_ENCRYPTED_FILEPATH = "encrypted.txt";
    public static final String EMPTY_STRING_ORIGINAL_FILEPATH = "text.txt";
    public static final String EMPTY_STRING_DECRYPTED_FILEPATH = "decrypted.txt";
    public static final String EMPTY_STRING_BRUTEFORCE_FILEPATH = "bruteforce.txt";
    public static final int KEY = 50;

}

