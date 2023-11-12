package com.javarush.kramorenko.viewConsole;


import com.javarush.kramorenko.command.*;
import com.javarush.kramorenko.constants.Const;
import com.javarush.kramorenko.exception.AppException;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void runApplication() {
        System.out.println(Messages.MENU);
            int actionNumber = chooseAction();
            runAction(actionNumber);
    }

    private int chooseAction() {
        int actionNumber = -1;
        while (actionNumber < 0 || actionNumber > 4) {
            try {
                actionNumber = Integer.parseInt(scanner.nextLine());
                if (actionNumber < 0 || actionNumber > 4) {
                    throw new AppException();
                }
            } catch (NumberFormatException e) {
                System.out.println(Const.INVALID_INPUT);
            } catch (AppException e) {
                System.out.printf(Const.NUMBER_IS_NOT_IN_LIST,actionNumber);
            }
        }
        return actionNumber;
    }
    private void runAction(int actionNumber){
        switch (actionNumber) {
            case 1 -> new Encode().encode();
            case 2 -> new Decode().decode();
            case 3 -> new BruteForce().bruteForce();
            case 4 -> new Exit().exit();
            default ->
                    System.out.println(Messages.INCORRECT_ACTION);
        }
    }
}
