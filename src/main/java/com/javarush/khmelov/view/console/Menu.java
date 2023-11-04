package com.javarush.khmelov.view.console;

import com.javarush.levchuk.constant.UtilConstants;

import java.util.Scanner;

import static com.javarush.khmelov.view.console.Messages.*;
import static com.javarush.levchuk.constant.UtilConstants.ERROR_MESSAGES;

@SuppressWarnings("ClassCanBeRecord")
public class Menu {

    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getArgs() {
        int mode = getMode(scanner);
        String[] args = new String[QUESTIONS[mode].length];
        args[0] = QUESTIONS[mode][0][0];
        for (int i = 1; i < args.length; i++) {
            String quest = QUESTIONS[mode][i][0];
            System.out.println(quest);
            String answer = scanner.nextLine();
            args[i] = "".equals(answer.trim()) ? QUESTIONS[mode][i][1] : answer;
        }
        return args;
    }

    private static int getMode(Scanner scanner) {
        int mode;
        do {
            System.out.println(MESSAGE_SELECT_MODE);
            String input = scanner.nextLine();
            mode = switch (input) {
                case "1" -> 0;
                case "2" -> 1;
                case "3" -> 2;
                case "4" -> 3;
                case "5" -> 4;
                default -> {
                    System.err.println(ERROR_MESSAGES[1]);
                    yield -1;
                }
            };
        } while (mode < 0);
        return mode;
    }
}
