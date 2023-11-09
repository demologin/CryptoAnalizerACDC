package com.javarush.baibakov;


public class Const {

    private Const() {
    }

    private static final String rus = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String symbols = "\n☮.,”’:-!?()IVX ";
    public static final char[] CHARS = (rus.toLowerCase() + symbols).toCharArray();
    static final String MENU = "1. - Encrypt\n2. - Decrypt\n3. - Not released\n4. - Not released\n5. - Exit";
    static final String MODE_ENCRYPT = "1";
    static final String MODE_DECRYPT = "2";
    static final String EXIT = "5";
    static final String SOURCE_FILE = "Enter source file path";
    static final String TARGET_FILE = "Enter destination file path";
    static final String KEY = "Enter key";
    static final String COMPLETED= "Completed";
}
