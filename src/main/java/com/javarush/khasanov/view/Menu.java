package com.javarush.khasanov.view;

import com.javarush.khasanov.controller.Actions;
import com.javarush.khasanov.exception.AppException;

import java.util.Scanner;

import static com.javarush.khasanov.view.Messages.*;


public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    private int selectAction() {
        StringBuilder actions = new StringBuilder();
        Actions[] values = Actions.values();
        for (int i = 0; i < values.length; i++) {
            actions.append(i + 1).append(". ").append(values[i]);
            actions.append("\n");
        }
        System.out.printf(Messages.MESSAGE_SELECT_ACTION, actions);

        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input) - 1;
        } catch (NumberFormatException e) {
            throw new AppException("Incorrect selection");
        }
    }

    public String[] getArgs() {
        int selectedAction = selectAction();
        String[] args = new String[QUESTIONS[selectedAction].length];
        args[0] = QUESTIONS[selectedAction][0][0];
        for (int i = 1; i < args.length; i++) {
            String question = QUESTIONS[selectedAction][i][0];
            System.out.println(question);
            String answer = scanner.nextLine();
            args[i] = answer.trim().isEmpty() ? QUESTIONS[selectedAction][i][1] : answer;
        }
        return args;
    }


}
