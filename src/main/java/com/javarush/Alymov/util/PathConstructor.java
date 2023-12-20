package com.javarush.Alymov.util;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public  class PathConstructor {
    public PathConstructor(Scanner inputStream) {
    }

    public static String PATH_OF_TEXT = null;
    public static String PATH_OF_DEFAULT_TEXT = System.getProperty("user.dir") + File.separator + "text" + File.separator + "text.txt";
    public static String PATH_OF_DEFAULT_RESULT_ENCODE = System.getProperty("user.dir") + File.separator + "text" + File.separator + "encode_text.txt";
    public static String PATH_OF_DEFAULT_RESULT_DECODE = System.getProperty("user.dir") + File.separator + "text" + File.separator + "decode_text.txt";
    public static String FILE_PATH = System.getProperty("user.dir") + File.separator + "text" + File.separator;

    public static String getPath (Scanner inputStream){
        PATH_OF_TEXT = inputStream.nextLine();
        return PATH_OF_TEXT;
    }
    public static int getPathLength(Scanner inputStream){
        getPath(inputStream);
        int pathLength = PATH_OF_TEXT.length();
        return pathLength;
    }
}
