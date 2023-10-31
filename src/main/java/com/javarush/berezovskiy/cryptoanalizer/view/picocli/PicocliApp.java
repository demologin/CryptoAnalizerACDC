package com.javarush.berezovskiy.cryptoanalizer.view.picocli;

import com.javarush.berezovskiy.cryptoanalizer.controller.MainController;
import com.javarush.berezovskiy.cryptoanalizer.entity.Result;
import com.javarush.berezovskiy.cryptoanalizer.exception.AppException;

import java.util.Arrays;

@SuppressWarnings("ClassCanBeRecord")
public class PicocliApp {

    private final MainController mainController;

    public PicocliApp(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run(String[] args) {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainController.doAction(action, parameters);
        } else
            throw new AppException("no args");
    }
}
