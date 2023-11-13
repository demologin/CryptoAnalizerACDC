package com.javarush.shvetsov;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class isCorrectPathClass {
    static String pathOne;
    static String pathTwo;
    static String pathThree;
    static String pathDefaultOrig = "C:\\Users\\User\\Desktop\\JAVA PROJECT\\CryptoAnalizerACDC2\\src\\main\\java\\com\\javarush\\shvetsov\\Files\\textOrig.txt";
    static String pathDefaultEncrypt = "C:\\Users\\User\\Desktop\\JAVA PROJECT\\CryptoAnalizerACDC2\\src\\main\\java\\com\\javarush\\shvetsov\\Files\\encrypt.txt";
    static String pathDefaultDecrypt = "C:\\Users\\User\\Desktop\\JAVA PROJECT\\CryptoAnalizerACDC2\\src\\main\\java\\com\\javarush\\shvetsov\\Files\\decrypt.txt";

    static void isCorrectPath(Scanner scanner) {
        boolean currentPath = false;
        while (!currentPath) {
            System.out.println(Dialog.MESSAGEFILEPATH);
            pathOne = scanner.next();

            if (pathOne.equals("1")) {
                pathOne = pathDefaultOrig;
                currentPath = true;
            } else if (Files.exists(Path.of(pathOne))) {
                currentPath = true;
            } else {
                System.out.println(Dialog.MESSAGEUNCURRECTPATH);

            }
        }
    }
    static void isCorrectPathTwo(Scanner scanner) {
        boolean currentPath = false;
        while (!currentPath) {

            pathTwo = scanner.next();

            if (pathTwo.equals("1")) {
                pathTwo = pathDefaultEncrypt;
                currentPath = true;
            } else if (Files.exists(Path.of(pathTwo))) {
                currentPath = true;
            } else {
                System.out.println(Dialog.MESSAGEUNCURRECTPATH);

            }
        }
    }static void isCorrectPathThree(Scanner scanner) {
        boolean currentPath = false;
        while (!currentPath) {

            pathThree = scanner.next();

            if (pathThree.equals("1")) {
                pathThree = pathDefaultDecrypt;
                currentPath = true;
            } else if (Files.exists(Path.of(pathThree))) {
                currentPath = true;
            } else {
                System.out.println(Dialog.MESSAGEUNCURRECTPATH);

            }
        }
    }
}
