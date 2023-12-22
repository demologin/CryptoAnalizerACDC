package com.javarush.Alymov.util;

import java.io.File;
import java.util.Scanner;

public  class PathConstructor {
    public PathConstructor() {
    }

    public static String PATH_OF_TEXT = null;
    public static String PATH_OF_DEFAULT_TEXT_FOR_ENCODE = System.getProperty("user.dir") + File.separator + "text" + File.separator + "text.txt";
    public static String PATH_OF_DEFAULT_RESULT_ENCODE = System.getProperty("user.dir") + File.separator + "text" + File.separator + "encode_text.txt";
    public static String PATH_OF_DEFAULT_TEXT_FOR_DECODE = System.getProperty("user.dir") + File.separator + "text" + File.separator + "encode_text.txt";
    public static String PATH_OF_DEFAULT_RESULT_DECODE = System.getProperty("user.dir") + File.separator + "text" + File.separator + "decode_text.txt";

    public static String getPath (Scanner inputStream){
        PATH_OF_TEXT = inputStream.nextLine();
        return PATH_OF_TEXT;
    }
}
