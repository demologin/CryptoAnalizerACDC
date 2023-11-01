package com.javarush.levchuk.constant;

import java.io.File;

public interface UtilConstants {
    String TEXT_MAIN_MENU =
            "\n___________________________\n" +
            "Please select mode:\n" +
            "1. Encrypt\n" +
            "2. Decrypt\n" +
            "3. Brute force\n" +
            "4. Analyze\n" +
            "5. Exit\n";
    String DEFAULT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    String DICTIONARY_TEXT_SOURCE = System.getProperty("user.dir") + File.separator + "text"+ File.separator + "dict.txt";


}
