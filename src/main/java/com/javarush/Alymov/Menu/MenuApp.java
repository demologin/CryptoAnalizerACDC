package com.javarush.Alymov.Menu;

import com.javarush.Alymov.Command.Encode;
import com.javarush.Alymov.Command.Exit;
import com.javarush.Alymov.util.PathConstructor;

import java.util.Scanner;

public class MenuApp {
    public static void showMenu(Scanner inputStream){
        System.out.println(
                MenuMessages.POINT_OF_MENU_1 + "\n"+
                MenuMessages.POINT_OF_MENU_2 + "\n"+
                MenuMessages.POINT_OF_MENU_3 + "\n"+
                MenuMessages.POINT_OF_MENU_4 + "\n");
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
                case 1 -> {
                    System.out.println(MenuMessages.FIRST_RESULT_POINT_OF_MENU_1);
                    String sourcePath = PathConstructor.getPath(inputStream);
                    if (sourcePath.isEmpty()) {
                        sourcePath = PathConstructor.PATH_OF_DEFAULT_TEXT;
                        System.out.println();
                    }
                    System.out.println(MenuMessages.SECOND_RESULT_POINT_OF_MENU_1);
                    String destinationPath = PathConstructor.getPath(inputStream);
                    if (destinationPath.isEmpty()) {
                        destinationPath = PathConstructor.PATH_OF_DEFAULT_RESULT_ENCODE;
                        System.out.println();
                    } else {
                        System.out.println("mode 2");
                    }
                    System.out.println(MenuMessages.THIRD_RESULT_POINT_OF_MENU_1);
                    try {
                        int step = 0;
                        while (step <= 0) {
                            step = Integer.parseInt(inputStream.nextLine());
                            Encode.encoder( sourcePath, destinationPath, step);
                        }
                    } catch (NumberFormatException i) {
                        System.out.println(MenuMessages.RESULT_OF_WRONG_ENTER);
                    }
                }
                case 2 -> System.out.println(MenuMessages.RESULT_POINT_OF_MENU_2);
                case 3 -> Exit.choiceExit();
                case 4 -> System.out.println(MenuMessages.RESULT_POINT_OF_MENU_4);
                default -> System.out.println(MenuMessages.RESULT_OF_WRONG_ENTER);
            }
        }
    }
}
