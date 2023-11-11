package com.javarush.kuzmina.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.javarush.kuzmina.resources.MethodsCipher.cipher;
import static com.javarush.kuzmina.resources.MethodsDecipher.decipher;
import static com.javarush.kuzmina.resources.Dialogue.*;
import static com.javarush.kuzmina.resources.ExtraMethods.*;

public class MethodsMain {

    public static String readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }


    public static void ifAnswerCipher() {
        System.out.println(ASK_TEXT);
        Scanner scanText = new Scanner(System.in);
        String text = scanText.nextLine();
        char[] textArr = textToArray(text);
        System.out.println(CHOOSE_NUMBER);
        Scanner scanNumber = new Scanner(System.in);
        while (scanNumber.hasNext()) {
            try {
                int number = Integer.parseInt(scanNumber.next());
                if (number > 0 && number < 32) {
                    char[] textCipher = cipher(textArr, number);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (char value : textCipher) stringBuilder.append(value);
                    String joinedString = stringBuilder.toString();
                    System.out.println("\n" + joinedString);
                    System.out.println(CONGRATULATION + RETURN);
                    break;
                   }
            } catch (NumberFormatException e) {
                System.out.println(MISUNDERSTANDING);
            }
        }
    }



    public static void ifAnswerDecipher() {
        System.out.println(ASK_DETEXT);
        Scanner scanDeText = new Scanner(System.in);
        String decText = scanDeText.nextLine();
        char[] cipherNewArr = textToArray(decText);
        System.out.println(CHOOSE_NUMBER);
        Scanner scanNewNumber = new Scanner(System.in);
        while (scanNewNumber.hasNext()) {
            try {
                int newNumber = Integer.parseInt(scanNewNumber.next());
                if (newNumber > 0 && newNumber < 32) {
                    char[] newTextDecipher = decipher(cipherNewArr, newNumber);
                    StringBuilder stringBuilder3 = new StringBuilder();
                    for (char c : newTextDecipher) stringBuilder3.append(c);
                    String newString = stringBuilder3.toString();
                    System.out.println("\n" + newString);
                    System.out.println(RETURN);
                    break;
                } else {
                    System.out.println(MISUNDERSTANDING);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(MISUNDERSTANDING);
            }
        }
    }

    public static void ifAnswerCipherFromFile() {
        System.out.println(ASK_PATH);
        Scanner scanPath = new Scanner(System.in);
        String path = scanPath.nextLine();
        String textFile = null;
        String content = null;
        try {
            textFile = readFile(path);
        } catch (IOException ex) {
            System.out.println(MISUNDERSTANDING);
        }
        char[] textFileArr = textToArray(textFile);
        System.out.println(CHOOSE_NUMBER);
        Scanner scanNumber = new Scanner(System.in);
        while (scanNumber.hasNext()) {
            try {
                int number = Integer.parseInt(scanNumber.next());
                if (number > 0 && number < 32) {
                    char[] textFileCipher = cipher(textFileArr, number);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (char value : textFileCipher) stringBuilder.append(value);
                    String joinedString = stringBuilder.toString();
                    System.out.println("\n" + joinedString);
                    System.out.println(CONGRATULATION + RETURN);
                    break;
                   }
                } catch (NumberFormatException e) {
                System.out.println(MISUNDERSTANDING);
            }
        }
    }

    public static void ifAnswerDecipherFromFile() {
        System.out.println(ASK_PATH);
        Scanner scanPath = new Scanner(System.in);
        String path2 = scanPath.nextLine();
        String detextFile = null;
        try {
            detextFile = readFile(path2);
        } catch (IOException ex) {
            System.out.println(MISUNDERSTANDING);
        }
        char[] cipherNewArr = textToArray(detextFile);
        System.out.println(CHOOSE_NUMBER);
        Scanner scanNewNumber = new Scanner(System.in);
        while (scanNewNumber.hasNext()) {
            try {
                int newNumber = Integer.parseInt(scanNewNumber.next());
                if (newNumber > 0 && newNumber < 32) {
                    char[] newTextDecipher = decipher(cipherNewArr, newNumber);
                    StringBuilder stringBuilder3 = new StringBuilder();
                    for (char c : newTextDecipher) stringBuilder3.append(c);
                    String newString = stringBuilder3.toString();
                    System.out.println("\n" + newString);
                    System.out.println(RETURN);
                    break;
                } else {
                    System.out.println(MISUNDERSTANDING);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(MISUNDERSTANDING);
            }
        }
    }

}




