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
        System.out.println(Constant.CHOOSE_VARIANT);
        chooseVariant();

    }

    private int chooseVariant() {
        int numberOfOption = 0;
        while (numberOfOption<1 || numberOfOption>3) {
            try {
                numberOfOption = Integer.parseInt(console.nextLine());
                if (numberOfOption < 1 || numberOfOption > 3) {
                    throw new AppException(Constant.NON_EXISTENT_NUMBER);
                }
            } catch (NumberFormatException e) {
                throw new AppException(Constant.WRONG_FORMAT, e);
            }
        }
        return numberOfOption;
    }
    public void executeOption(){

    }
}


