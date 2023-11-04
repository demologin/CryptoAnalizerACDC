package com.javarush.levchuk.constant;

import java.io.File;

public interface UtilConstants {
    String TEXT_MAIN_MENU =
            "\n___________________________\n"+
                    "1. Encrypt\n" +
                    "2. Decrypt\n" +
                    "3. Brute force\n" +
                    "4. Exit\n";
    String DEFAULT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    String DEFAULT_INITIAL_FILE_NAME = "text.txt";
    String DEFAULT_ENCRYPT_FILE_NAME = "encrypted.txt";
    String DEFAULT_DECRYPT_FILE_NAME = "decrypted.txt";
    String DEFAULT_BRUTEFORCE_FILE_NAME = "bruteDecrypted.txt";
    int DEFAULT_KEY = 1;

    String[] CONTEXT_MESSAGES ={
            "\nEnter the full path to the file. Or its name.extension if it is in the default folder (Or Enter for %s) : \s\n",
            "Enter the full path or name.extension for the output file (Or Enter for %s) : \s\n",
            "Enter key (int number OR Enter for key=%d) : \s\n",
            "Result is written to a file : \s\n"

    };
    String[] ERROR_MESSAGES ={
            "\nIncorrect key format. Please use numbers\n",
            "\nIncorrect selection. Please use numbers from 1 to 4\n",
            "\nIncorrect input file.\n"
    };
    String ANSI_RESET = "\u001B[0m";
    String ANSI_GREEN = "\u001B[32m";
}
