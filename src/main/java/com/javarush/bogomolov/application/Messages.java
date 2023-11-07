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
    String KEY = "Please enter key";
    String DESTINATION_PATH = "Please enter destination path or filename";
    String APPLICATION_CLOSED = "application closed";
    String FILE_ENCRYPTED = "file has been encrypted!";
    String FILE_DECRYPTED="file has been decrypted!";
    String ERROR ="ERROR";

}
