package com.javarush.miroshnyk;

import com.javarush.miroshnyk.resorses.ConsoleHelper;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static boolean exit = false;
    public static int cipherKey = 1;
    public static String textFileName = "";
    public static String encryptedFileName = "";
    public static String decryptedFileName = "";
    public static ArrayList<Character> mainBuffer = new ArrayList<>();
    public static ArrayList<String> mainBufferString = new ArrayList<>();
    public static String directoryPathForWorkFileSave = "";

    public static void main(String[] args) throws UnsupportedEncodingException {

        File currentClass = new File (URLDecoder.decode(Runner.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
        // из папки E:\JAVA\Projects\CryptoAnalizerACDC\target\classes не читает русские буквы
        directoryPathForWorkFileSave = currentClass.getPath().replaceAll("\\\\target\\\\classes", "\\\\src\\\\main\\\\java\\\\com\\\\javarush\\\\miroshnyk\\\\resorses\\\\workFiles") + "\\";

        System.out.println(directoryPathForWorkFileSave);

        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.askOperation();

    }

}
