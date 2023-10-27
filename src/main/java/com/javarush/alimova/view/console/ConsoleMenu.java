package com.javarush.alimova.view.console;

import com.javarush.alimova.controller.CommandContainer;
import com.javarush.alimova.controller.MainController;
import com.javarush.alimova.dictionary.Const;

import java.util.Scanner;

public class ConsoleMenu {
    public ConsoleMenu() {
    }


    public void startMenu() {
        ConsoleMenu menu = new ConsoleMenu();

        boolean loopMenu = false;
        while (!loopMenu) {
            menu.printMenu();
            loopMenu = menu.parserInputData();
        }

    }

    public void printMenu() {
        System.out.println(Const.START_PROGRAM);
        for (int i = 0; i < CommandContainer.commandSet.length; i++) {
            System.out.printf("%d. %s\n", i + 1, CommandContainer.commandSet[i]);
        }
    }

    public boolean parserInputData() {
        Scanner console = new Scanner(System.in);
        int numbAction = console.nextInt();
        while (numbAction > CommandContainer.commandSet.length) {
            System.out.println(Const.INCORRECT_COMMAND);
            //тут надо бы ожидать верный ввод
            numbAction = console.nextInt();
        }
        boolean readArg = switch(numbAction) {
            case 1 -> menuEncoding();
            case 2 -> menuDecoding();
            case 3 -> menuBruteForce();
            case 4 -> menuStaticAnalyzer();
            case 5 -> menuExit();
            default -> false;       //подобного варианта не должно быть в теории
        };

        if (!readArg) {
            System.out.println(Const.CONSOLE_INPUT_ERROR);        //как-то зациклить (сейчас выходит из меню)
        }
        return readArg;

    }

    private boolean menuEncoding() {
        Scanner console = new Scanner(System.in);
        System.out.println(Const.MENU_ENCODING_ARG_ONE);
        String fileInput = console.nextLine();
        if (fileInput.isEmpty()) {
            fileInput = Const.ENCODING_DEFAULT_INPUTFILE;
        } else if (!fileInput.endsWith(".txt")) {
            return false;
        }

        System.out.println(Const.MENU_ENCODING_ARG_TWO);
        String fileOutput = console.nextLine();
        if (fileOutput.isEmpty()) {
            fileOutput = Const.ENCODING_DEFAULT_OUTPUTFILE;
        } else if (!fileOutput.endsWith(".txt")) {
            return false;
        }

        System.out.println(Const.MENU_ENCODING_ARG_THREE);
        String keyString = console.nextLine();
        if (keyString.isEmpty()) {
            keyString = Const.ENCODING_DEFAULT_KEY;
        }
        if (Integer.parseInt(keyString) < 0) {
            return false;
        }
        MainController.giveCommand(CommandContainer.ENCODING.name(), new String[]{fileInput, fileOutput, keyString});

        return true;


    }

    private boolean menuDecoding() {

        Scanner console = new Scanner(System.in);
        System.out.println(Const.MENU_DECODING_ARG_ONE);
        String fileInput = console.nextLine();
        if (fileInput.isEmpty()) {
            fileInput = Const.DECODING_DEFAULT_INPUTFILE;
        } else if (!fileInput.endsWith(".txt")) {
            return false;
        }

        System.out.println(Const.MENU_DECODING_ARG_TWO);
        String fileOutput = console.nextLine();
        if (fileOutput.isEmpty()) {
            fileOutput = Const.DECODING_DEFAULT_OUTPUTFILE;
        } else if (!fileOutput.endsWith(".txt")) {
            return false;
        }

        System.out.println(Const.MENU_DECODING_ARG_THREE);
        String keyString = console.nextLine();
        if (keyString.isEmpty()) {
            keyString = Const.DECODING_DEFAULT_KEY;
        }
        if (Integer.parseInt(keyString) < 0) {
            return false;
        }
        MainController.giveCommand(CommandContainer.DECODING.name(), new String[]{fileInput, fileOutput, keyString});

        return true;
    }

    private boolean menuBruteForce() {
        //нужно тут переопределить всё
        Scanner console = new Scanner(System.in);
        System.out.println(Const.MENU_BRUTE_FORCE_ARG_ONE);
        String fileInput = console.nextLine();
        if (fileInput.isEmpty()) {
            fileInput = Const.BRUTE_FORCE_DEFAULT_INPUTFILE;
        } else if (!fileInput.endsWith(".txt")) {
            return false;
        }

        System.out.println(Const.MENU_BRUTE_FORCE_ARG_TWO);
        String fileOutput = console.nextLine();
        if (fileOutput.isEmpty()) {
            fileOutput = Const.BRUTE_FORCE_DEFAULT_OUTPUTFILE;
        } else if (!fileOutput.endsWith(".txt")) {
            return false;
        }

        MainController.giveCommand(CommandContainer.BRUTEFORCE.name(), new String[]{fileInput, fileOutput});
        return true;
    }

    private boolean menuStaticAnalyzer() {

        Scanner console = new Scanner(System.in);
        System.out.println(Const.MENU_STATIC_ANALYZER_ARG_ONE);
        String fileInput = console.nextLine();
        if (fileInput.isEmpty()) {
            fileInput = Const.STATIC_ANALYZER_DEFAULT_INPUTFILE;
        } else if (!fileInput.endsWith(".txt")) {
            return false;
        }

        System.out.println(Const.MENU_STATIC_ANALYZER_ARG_TWO);
        String fileOutput = console.nextLine();
        if (fileOutput.isEmpty()) {
            fileOutput = Const.STATIC_ANALYZER_DEFAULT_OUTPUTFILE;
        } else if (!fileOutput.endsWith(".txt")) {
            return false;
        }

        System.out.println(Const.MENU_STATIC_ANALYZER_ARG_THREE);
        String fileSource = console.nextLine();
        if (fileSource.isEmpty()) {
            fileSource = Const.STATIC_ANALYZER_DEFAULT_SOURCE;
        } else if (!fileSource.endsWith(".txt")) {
            return false;
        }
        MainController.giveCommand(CommandContainer.ANALYZER.name(), new String[]{fileInput, fileOutput, fileSource});

        return true;
    }


    private boolean menuExit() {
        return true;
    }
}
