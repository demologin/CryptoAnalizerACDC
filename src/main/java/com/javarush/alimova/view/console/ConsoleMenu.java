package com.javarush.alimova.view.console;

import com.javarush.alimova.commands.Result;
import com.javarush.alimova.controller.CommandContainer;
import com.javarush.alimova.controller.MainController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {

    MainController mainController;
    public ConsoleMenu(MainController mainController) {
        this.mainController = mainController;
    }


    public void startMenu() {

        boolean loopMenu = false;
        while (!loopMenu) {
            printMenu();
            loopMenu = parserInputData();
        }

    }

    private void printMenu() {
        System.out.println(ConsoleConst.START_PROGRAM);
        for (int i = 0; i < CommandContainer.commandSet.length; i++) {
            System.out.printf("%d. %s\n", i + 1, CommandContainer.commandSet[i]);
        }
    }

    private boolean parserInputData() {
        Scanner console = new Scanner(System.in);
        int numbAction;
        try {
            numbAction = console.nextInt();
        } catch(InputMismatchException e) {
            System.out.println(ConsoleConst.INCORRECT_COMMAND);
            return false;
        }
        if (numbAction > CommandContainer.commandSet.length || numbAction < 0) {
            System.out.println(ConsoleConst.INCORRECT_COMMAND);
            return false;
        }

        boolean readArg = switch(numbAction) {
            case 1 -> menuEncoding();
            case 2 -> menuDecoding();
            case 3 -> menuBruteForce();
            case 4 -> menuStaticAnalyzer();
            case 5 -> menuExit();
            default -> false;
        };

        if (!readArg) {
            System.out.println(ConsoleConst.CONSOLE_INPUT_ERROR);
        }
        return readArg;

    }

    private boolean menuEncoding() {
        Scanner console = new Scanner(System.in);
        System.out.println(ConsoleConst.MENU_ENCODING_ARG_ONE);
        String fileInput = console.nextLine();
        if (fileInput.isEmpty()) {
            fileInput = ConsoleConst.ENCODING_DEFAULT_INPUTFILE;
        } else if (!fileInput.endsWith(".txt")) {
            System.out.println(ConsoleConst.INCORRECT_FILE);
            return false;
        }

        System.out.println(ConsoleConst.MENU_ENCODING_ARG_TWO);
        String fileOutput = console.nextLine();
        if (fileOutput.isEmpty()) {
            fileOutput = ConsoleConst.ENCODING_DEFAULT_OUTPUTFILE;
        } else if (!fileOutput.endsWith(".txt")) {
            System.out.println(ConsoleConst.INCORRECT_FILE);
            return false;
        }

        System.out.println(ConsoleConst.MENU_ENCODING_ARG_THREE);
        String keyString = console.nextLine();
        if (keyString.isEmpty()) {
            keyString = ConsoleConst.ENCODING_DEFAULT_KEY;
        }
        try {
            if (Integer.parseInt(keyString) < 0) {
                System.out.println(ConsoleConst.INCORRECT_KEY);
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println(ConsoleConst.INCORRECT_KEY);
            return false;
        }

        Result result = mainController.giveCommand(CommandContainer.ENCODING.name(), new String[]{fileInput, fileOutput, keyString});
        mainController.printResultCommand(result);

        return true;


    }

    private boolean menuDecoding() {

        Scanner console = new Scanner(System.in);
        System.out.println(ConsoleConst.MENU_DECODING_ARG_ONE);
        String fileInput = console.nextLine();
        if (fileInput.isEmpty()) {
            fileInput = ConsoleConst.DECODING_DEFAULT_INPUTFILE;
        } else if (!fileInput.endsWith(".txt")) {
            System.out.println(ConsoleConst.INCORRECT_FILE);
            return false;
        }

        System.out.println(ConsoleConst.MENU_DECODING_ARG_TWO);
        String fileOutput = console.nextLine();
        if (fileOutput.isEmpty()) {
            fileOutput = ConsoleConst.DECODING_DEFAULT_OUTPUTFILE;
        } else if (!fileOutput.endsWith(".txt")) {
            System.out.println(ConsoleConst.INCORRECT_FILE);
            return false;
        }

        System.out.println(ConsoleConst.MENU_DECODING_ARG_THREE);
        String keyString = console.nextLine();
        if (keyString.isEmpty()) {
            keyString = ConsoleConst.DECODING_DEFAULT_KEY;
        }
        try {
            if (Integer.parseInt(keyString) < 0) {
                System.out.println(ConsoleConst.INCORRECT_KEY);
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println(ConsoleConst.INCORRECT_KEY);
            return false;
        }
        Result result = mainController.giveCommand(CommandContainer.DECODING.name(), new String[]{fileInput, fileOutput, keyString});
        mainController.printResultCommand(result);

        return true;
    }

    private boolean menuBruteForce() {
        //нужно тут переопределить всё
        Scanner console = new Scanner(System.in);
        System.out.println(ConsoleConst.MENU_BRUTE_FORCE_ARG_ONE);
        String fileInput = console.nextLine();
        if (fileInput.isEmpty()) {
            fileInput = ConsoleConst.BRUTE_FORCE_DEFAULT_INPUTFILE;
        } else if (!fileInput.endsWith(".txt")) {
            System.out.println(ConsoleConst.INCORRECT_FILE);
            return false;
        }

        System.out.println(ConsoleConst.MENU_BRUTE_FORCE_ARG_TWO);
        String fileOutput = console.nextLine();
        if (fileOutput.isEmpty()) {
            fileOutput = ConsoleConst.BRUTE_FORCE_DEFAULT_OUTPUTFILE;
        } else if (!fileOutput.endsWith(".txt")) {
            System.out.println(ConsoleConst.INCORRECT_FILE);
            return false;
        }

        Result result = mainController.giveCommand(CommandContainer.BRUTEFORCE.name(), new String[]{fileInput, fileOutput});
        mainController.printResultCommand(result);
        return true;
    }

    private boolean menuStaticAnalyzer() {

        Scanner console = new Scanner(System.in);
        System.out.println(ConsoleConst.MENU_STATIC_ANALYZER_ARG_ONE);
        String fileInput = console.nextLine();
        if (fileInput.isEmpty()) {
            fileInput = ConsoleConst.STATIC_ANALYZER_DEFAULT_INPUTFILE;
        } else if (!fileInput.endsWith(".txt")) {
            System.out.println(ConsoleConst.INCORRECT_FILE);
            return false;
        }

        System.out.println(ConsoleConst.MENU_STATIC_ANALYZER_ARG_TWO);
        String fileOutput = console.nextLine();
        if (fileOutput.isEmpty()) {
            fileOutput = ConsoleConst.STATIC_ANALYZER_DEFAULT_OUTPUTFILE;
        } else if (!fileOutput.endsWith(".txt")) {
            System.out.println(ConsoleConst.INCORRECT_FILE);
            return false;
        }

        System.out.println(ConsoleConst.MENU_STATIC_ANALYZER_ARG_THREE);
        String fileSource = console.nextLine();
        if (fileSource.isEmpty()) {
            fileSource = ConsoleConst.STATIC_ANALYZER_DEFAULT_SOURCE;
        } else if (!fileSource.endsWith(".txt")) {
            System.out.println(ConsoleConst.INCORRECT_FILE);
            return false;
        }
        Result result = mainController.giveCommand(CommandContainer.ANALYZER.name(), new String[]{fileInput, fileOutput, fileSource});
        mainController.printResultCommand(result);

        return true;
    }


    private boolean menuExit() {
        return true;
    }
}
