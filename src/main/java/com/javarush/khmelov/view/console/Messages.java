package com.javarush.khmelov.view.console;

import com.javarush.khmelov.constant.Const;

interface Messages {
    String[][][] QUESTIONS = new String[][][]{
            {
                    {Const.ENCODE},
                    {"Enter source (full path OR only filename OR Enter for text.txt) :", "text.txt"},
                    {"Enter destination (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter key (int number OR Enter for key=1) :", "1"},
            },
            {
                    {Const.DECODE},
                    {"Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter destination (full path OR only filename OR Enter for decrypted.txt) :", "decrypted.txt"},
                    {"Enter key (int number OR Enter for key=1) :", "1"},
            },
            {
                    {Const.BRUTEFORCE},
                    {"Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter destination (full path OR only filename OR Enter for bruteforce.txt) :", "bruteforce.txt"},
            },
            {
                    {Const.ANALYZE},
                    {"Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"},
                    {"Enter dictionary  (full path OR only filename OR Enter for dict.txt) :", "dict.txt"},
                    {"Enter destination (full path OR only filename OR Enter for analyzed.txt) :", "analyzed.txt"},
            },
            {
                    {"Exit"},
            }
    };

    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_GREEN = "\u001B[32m";

    String LINE = "-".repeat(20);
    String MESSAGE_SELECT_MODE = LINE +
            ANSI_BLUE + "\nPlease select mode:\n" + ANSI_CYAN + """
            1. Encrypt
            2. Decrypt
            3. Brute force
            4. Analyze
            5. Exit
            """ + ANSI_RESET + LINE;

    String INCORRECT_SELECTION = "Incorrect selection";

    String OK_FORMAT = ANSI_GREEN + """
                Operation complete
                Result: %s
            """ + ANSI_RESET;

    String ERR_FORMAT = ANSI_PURPLE + """
                ERROR
                Message: %s
            """ + ANSI_RESET;


}
