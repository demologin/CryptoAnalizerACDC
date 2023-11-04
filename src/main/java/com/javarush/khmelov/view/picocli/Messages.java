package com.javarush.khmelov.view.picocli;

interface Messages {

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
    String APP_DESCRIPTION = "Example: PicocliRunner command parameters...";
}
