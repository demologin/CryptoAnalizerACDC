package com.javarush.khasanov.view;

import com.javarush.khasanov.controller.*;
import com.javarush.khasanov.entity.*;

import java.util.Arrays;

public class Application {
    private final MainController mainController;
    private final Menu menu;

    public Application(MainController mainController, Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }

    public void run(String[] args) {
        Result result;
        do {
            if (args.length == 0) {
                args = menu.getArgs();
            }
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            result = mainController.doAction(action, parameters);
            System.out.println(result);
            args = new String[0];
        } while (result.code == ResultCode.ERROR);
    }
}
