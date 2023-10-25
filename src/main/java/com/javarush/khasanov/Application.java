package com.javarush.khasanov;

import com.javarush.khasanov.controller.*;
import com.javarush.khasanov.entity.Result;
import com.javarush.khasanov.exception.AppException;

import java.util.Arrays;

public class Application {
    private final MainController mainController;
    private final Menu menu;

    public Application(MainController mainController, Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }

    public void run(String[] args) {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            Result result = mainController.doAction(action, parameters);
            System.out.println(result);
        } else {
            throw new AppException("args is empty");
        }
    }



}
