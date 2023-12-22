package com.javarush.Alymov.Menu;

import com.javarush.Alymov.Command.Decode;
import com.javarush.Alymov.Command.Encode;
import com.javarush.Alymov.Command.Exit;
import com.javarush.Alymov.util.PathConstructor;

import java.util.Scanner;

public class MenuApp {
    public static void showMenu(Scanner inputStream) {
        System.out.println(
                MenuMessages.POINT_OF_MENU_1 + "\n" +
                        MenuMessages.POINT_OF_MENU_2 + "\n" +
                        MenuMessages.POINT_OF_MENU_3 + "\n");
        getChoice(inputStream);
    }

    private static int Choice;

    private static void getChoice(Scanner inputStream) {
        while (Choice != 3) {
            try {
                Choice = Integer.parseInt(inputStream.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n");
            }

            switch (Choice) {
                case 1 -> pointOfMenuEncode(inputStream);
                case 2 -> pointOfMenuDecode(inputStream);
                case 3 -> Exit.choiceExit();
                default -> System.out.println(MenuMessages.RESULT_OF_WRONG_ENTER);
            }


        }
    }

    public static void pointOfMenuEncode(Scanner inputStream) {

        System.out.println(MenuMessages.ENCODE_1_STEP);
        String sourcePath = PathConstructor.getPath(inputStream);
        if (sourcePath.isEmpty()) {
            sourcePath = PathConstructor.PATH_OF_DEFAULT_TEXT_FOR_ENCODE;
        }
        System.out.println(MenuMessages.ENCODE_2_STEP);
        String destinationPath = PathConstructor.getPath(inputStream);
        if (destinationPath.isEmpty()) {
            destinationPath = PathConstructor.PATH_OF_DEFAULT_RESULT_ENCODE;
        }
        System.out.println(MenuMessages.ENCODE_3_STEP);
        try {
            int step = 0;
            while (step <= 0) {
                step = Integer.parseInt(inputStream.nextLine());
                Encode.encoder(sourcePath, destinationPath, step);
            }
        } catch (NumberFormatException i) {
            System.out.println(MenuMessages.RESULT_OF_WRONG_ENTER);
        }
    }
    public static void pointOfMenuDecode(Scanner inputStream) {
        System.out.println(MenuMessages.DECODE_1_STEP);
        String sourcePath = PathConstructor.getPath(inputStream);
        if (sourcePath.isEmpty()) {
            sourcePath = PathConstructor.PATH_OF_DEFAULT_TEXT_FOR_DECODE;
            System.out.println();
        }
        System.out.println(MenuMessages.DECODE_2_STEP);
        String destinationPath = PathConstructor.getPath(inputStream);
        if (destinationPath.isEmpty()) {
            destinationPath = PathConstructor.PATH_OF_DEFAULT_RESULT_DECODE;
            System.out.println();
        }
        System.out.println(MenuMessages.DECODE_3_STEP);
        try {
            int step = 0;
            while (step <= 0) {
                step = Integer.parseInt(inputStream.nextLine());
                Decode.decoder(sourcePath, destinationPath, step);
            }
        } catch (NumberFormatException i) {
            System.out.println(MenuMessages.RESULT_OF_WRONG_ENTER);
        }

    }
}
