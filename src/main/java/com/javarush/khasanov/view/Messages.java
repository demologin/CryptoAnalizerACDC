package com.javarush.khasanov.view;

public class Messages {
    public static final String[][][] QUESTIONS = new String[][][]{
            {
                    {"Encrypt"},
                    {"Enter source (full path OR only filename OR Enter for text.txt) :", "text.txt"},
                    {"Enter destination (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter key (int number OR Enter for key=1) :", "1"},
            },
            {
                    {"Decrypt"},
                    {"Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter destination (full path OR only filename OR Enter for decrypted.txt) :", "decrypted.txt"},
                    {"Enter key (int number OR Enter for key=1) :", "1"},
            },
            {
                    {"Exit"},
            }
    };

    public static final String LINE = "-".repeat(20);
    public static final String MESSAGE_SELECT_ACTION =
                    LINE + "\n" +
                    "\nPlease select mode:\n" +
                    "%s%n" +
                    LINE + "\n";

    public static final String INCORRECT_KEY = "Incorrect key";
    public static final String INCORRECT_FILE = "Incorrect file";

    public static final String OPERATION_COMPLETE = "Operation complete";
    public static final String INCORRECT_ACTION_NAME = "\"Incorrect action name\"";
}
