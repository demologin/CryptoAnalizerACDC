package com.javarush.kudra;

import com.javarush.kudra.commands.Decode;
import com.javarush.kudra.commands.Encode;
import com.javarush.kudra.commands.Exit;
import com.javarush.kudra.exceptions.AppException;
import com.javarush.kudra.constants.Constant;

import java.util.Scanner;

public class Menu {
    private final Scanner console;

    public Menu(Scanner console) {
        this.console = console;
    }

    public void runApplication(){
        System.out.println(Constant.CHOOSE_VARIANT);
        System.out.println("_________________________________");
        chooseVariant();

    }

    private void chooseVariant() {
        int numberOfOption;
        while (true) {
            try {
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


