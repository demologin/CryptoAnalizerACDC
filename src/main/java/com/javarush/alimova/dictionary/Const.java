package com.javarush.alimova.dictionary;

public interface Const {

    String START_PROGRAM = "Start coding program:\nSelect the required actions";

    String INCORRECT_COMMAND = "You entered the wrong command";

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

    String ERROR_FILE = "The problem with the file (incorrect path or other reasons)";







}
