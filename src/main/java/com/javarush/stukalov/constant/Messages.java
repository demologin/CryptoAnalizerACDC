package com.javarush.stukalov.constant;

public enum Messages {
    SELECT_TEXT_FILE_MESSAGE("\nEnter a path to the text file\n"),
    SELECT_ENCODED_TEXT_FILE_MESSAGE("\nEnter a path to the encoded text file\n"),
    SELECT_DECODED_TEXT_FILE_MESSAGE("\nEnter a path to the decoded text file\n"),
    INSERT_ENCODING_KEY("\nEnter the digit key for encoding\n"),
    INSERT_DECODING_KEY("\nEnter the digit key for decoding\n");
    private final String value;

    Messages(String value) {
        this.value = value;
    }
    public static void printTextFile() {
        System.out.println(SELECT_TEXT_FILE_MESSAGE.value);
    }
    public static void printEncodedTextFile() {
        System.out.println(SELECT_ENCODED_TEXT_FILE_MESSAGE.value);
    }
    public static void printDecodedTextFile() {
        System.out.println(SELECT_DECODED_TEXT_FILE_MESSAGE.value);
    }
    public static void printEncodingKey() {
        System.out.println(INSERT_ENCODING_KEY.value);
    }
    public static void printDecodingKey() {
        System.out.println(INSERT_DECODING_KEY.value);
    }

}
