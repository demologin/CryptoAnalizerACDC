package com.javarush.bogomolov.application;

import java.io.File;

public interface Messages {
    String SELECT_OPTION = """
            Please select an option:
                        1. Encrypt
                        2. Decrypt
                        3. Exit""";
    String INCORRECT_OPTION = "Option not found, please select again ";
    String CHOOSE_FILE = "Please provide file path or filename";
    String DEFAULT_PATH = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;
    String INCORRECT_PATH = "Path is incorrect";
    String KEY = "Please enter key number";
    String DESTINATION_PATH = "Please enter destination path or filename";
    String APPLICATION_CLOSED = "Application closed";
    String FILE_ENCRYPTED = "File has been encrypted!";
    String FILE_DECRYPTED="File has been decrypted!";
    String ERROR ="ERROR! Incorrect path or key(must be a number)";

}
