package com.javarush.kudra.constants;

import java.io.File;

public interface Constant {
    String PARENT_DIRECTORY = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    String CHOOSE_VARIANT = "Select one of the proposed options:\n1.Encode\n2.Decode\n3.Exit\n";
    String SOURCE_FILE = "Provide source (full path OR only filename OR Enter for %s) :\n";
    String DEST_FILE = "Provide destination (full path OR only filename OR Enter for %s) :\n";
    String INPUT_KEY = "Provide key\n";
    String INPUT_EXCEPTION ="Incorrect information. Try again\n";


    String NON_EXISTENT_NUMBER = "This number does not exist. Try again\n";
    String WRONG_FORMAT = "Wrong format. Enter the number\n";
    String INCORRECT_FILE_NAME = "Invalid file name entered\n";
    String EXIT = "Application completed\n";
}
