package com.javarush.levchuk.constant;

import java.io.File;
import java.nio.file.Path;

public interface UtilConstants {
    String TEXT_MAIN_MENU =
            "\n___________________________\n" +
            "Please select mode:\n" +
            "1. Encrypt\n" +
            "2. Decrypt\n" +
            "3. Brute force\n" +
            "4. Exit\n";
    String DEFAULT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    String DEFAULT_ENCRYPT_FILE_NAME="encrypted.txt";
    String DEFAULT_DECRYPT_FILE_NAME="decrypted.txt";
    String DEFAULT_BRUTEFORCE_FILE_NAME="bruteDecrypted.txt";

}
