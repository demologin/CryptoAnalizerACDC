package com.javarush.alimova.view.console;

public interface ConsoleConst {
    String START_PROGRAM = "Start coding program:\nSelect the required actions";

    String INCORRECT_COMMAND = "You entered the wrong command";

    String INCORRECT_KEY = "The key must be a positive number (from 1 to 41)";

    String INCORRECT_FILE = "The file must have a text file extension (.txt, etc.)";

    String MENU_ENCODING_ARG_ONE = "Enter the name of the incoming file or press 'enter' (default 'text.txt')";

    String ENCODING_DEFAULT_INPUTFILE = "text.txt";
    String ENCODING_DEFAULT_OUTPUTFILE = "encoding_out.txt";

    String MENU_ENCODING_ARG_TWO = "Enter the name of the resulting file and press 'enter' (default 'encoding_out.txt')";

    String MENU_ENCODING_ARG_THREE = "Enter the encryption key and press 'enter' (default key=5)";

    String ENCODING_DEFAULT_KEY = "5";
    String MENU_DECODING_ARG_ONE = "Enter the name of the incoming file or press 'enter' (default 'encoding_out.txt')";
    String DECODING_DEFAULT_INPUTFILE = "encoding_out.txt";

    String DECODING_DEFAULT_OUTPUTFILE = "decoding_out.txt";

    String MENU_DECODING_ARG_TWO = "Enter the name of the resulting file and press 'enter' (default 'decoding_out.txt')";
    String MENU_DECODING_ARG_THREE = "Enter the encryption key and press 'enter' (default key=5)";
    String DECODING_DEFAULT_KEY = "5";
    String CONSOLE_INPUT_ERROR = "You made a mistake when filling in the data. Please start from the beginning";

    String MENU_BRUTE_FORCE_ARG_ONE = "Your text must contain at least two sentences.\n" +
            "Enter the name of the incoming file or press 'enter' (default 'encoding_out.txt')";
    String BRUTE_FORCE_DEFAULT_INPUTFILE = "encoding_out.txt";

    String BRUTE_FORCE_DEFAULT_OUTPUTFILE = "bruteforce_out.txt";

    String MENU_BRUTE_FORCE_ARG_TWO = "Enter the name of the resulting file and press 'enter' (default 'bruteforce_out.txt')";

    String MENU_STATIC_ANALYZER_ARG_ONE = "Enter the name of the incoming file or press 'enter' (default 'encoding_out.txt')";
    String STATIC_ANALYZER_DEFAULT_INPUTFILE = "encoding_out.txt";

    String STATIC_ANALYZER_DEFAULT_OUTPUTFILE = "analyzer_out.txt";

    String MENU_STATIC_ANALYZER_ARG_TWO = "Enter the name of the resulting file and press 'enter' (default 'analyzer_out.txt')";
    String MENU_STATIC_ANALYZER_ARG_THREE = "Enter the name of the file with an example of the author's work and press 'enter' (default 'dict.txt')";
    String STATIC_ANALYZER_DEFAULT_SOURCE = "dict.txt";
}
