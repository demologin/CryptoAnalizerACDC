package com.javarush.kudra.constants;

import java.io.File;

public interface Constant {
    String PARENT_DIRECTORY = System.getProperty("user dir") + File.separator + "text" + File.separator;
    String CHOOSE_VARIANT = "Select one of the proposed options:/n1.Encode/n2.Decode/n3.Exit";
    String NON_EXISTENT_NUMBER = "This number does not exist. Try again";
    String WRONG_FORMAT = "Wrong format. Enter the number";
    String UNCORRECT_FILE_NAME = "Invalid file name entered";
}
