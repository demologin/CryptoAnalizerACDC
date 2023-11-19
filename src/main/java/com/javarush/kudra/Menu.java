package com.javarush.kudra;
import com.javarush.kudra.exceptions.AppException;
import com.javarush.kudra.constants.Constant;

import java.util.Scanner;

public class Menu {
    private final Scanner console;

    public Menu(Scanner console) {
        this.console = console;
    }

    public void runApplication(){
        chooseVariant();

    }

    private void chooseVariant() {
        int numberOfOption;

        while (true) {
            try {
                System.out.println(Constant.CHOOSE_VARIANT);
                System.out.println("_________________________________");
                numberOfOption = Integer.parseInt(console.nextLine());
                Action action = Action.getByNumberOfOption(numberOfOption);
                action.execute(console);
                if (action == Action.EXIT) {
                    System.out.println(Constant.EXIT);
                    break;
                }
            } catch (NumberFormatException e) {
                throw new AppException(Constant.WRONG_FORMAT, e);
            }
        }
    }
}


