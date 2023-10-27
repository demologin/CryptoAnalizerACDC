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

    String MENU_STATIC_ANALYZER_ARG_ONE = "Enter the name of the incoming file or press 'enter' (default 'encoding_out.txt')";
    String STATIC_ANALYZER_DEFAULT_INPUTFILE = "encoding_out.txt";

    String STATIC_ANALYZER_DEFAULT_OUTPUTFILE = "analyzer_out.txt";

    String MENU_STATIC_ANALYZER_ARG_TWO = "Enter the name of the resulting file and press 'enter' (default 'analyzer_out.txt')";
    String MENU_STATIC_ANALYZER_ARG_THREE = "Enter the name of the file with an example of the author's work and press 'enter' (default 'dict.txt')";
    String STATIC_ANALYZER_DEFAULT_SOURCE = "dict.txt";

    String APP_DESCRIPTION = "Reading parameters";

    String ENCODE = "encode";
    String DECODE = "decode";
    String BRUTEFORCE = "bruteforce";
    String ANALYZE = "analyze";
    String ENCODE_HELP = "Encrypt from file to file using key";
    String DECODE_HELP = "Decrypt from file to file using key";
    String BRUTEFORCE_HELP = "Decrypt from file to file using brute force";
    String ANALYZE_HELP = "Decrypt from file to file using statistical analysis";

    String SOURCE_FILE = "<source file>";
    String DICT_FILE = "<dict file>";
    String DEST_FILE = "<dest file>";
    String KEY = "<key>";

    String SOURCE_HELP = "source file with text to encrypt";
    String ENCRYPTED_SOURCE_HELP = "source file with encrypted text";
    String DICT_HELP = "dictionary file with sample test";
    String DEST_FILE_HELP = "dest file which should have decrypted text";
    String DEST_ENCRYPTED_FILE_HELP = "dest file which should have encrypted text";
    String KEY_HELP = "key for encryption";

    String SPECIFY_A_SUBCOMMAND = "Specify a subcommand";
    String APP_NAME = "PicocliRunner";







}
