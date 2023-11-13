package com.javarush.khmelov.view.picocli;

import com.javarush.khmelov.controller.MainController;
import com.javarush.khmelov.entity.Result;
import com.javarush.khmelov.exception.AppException;

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
