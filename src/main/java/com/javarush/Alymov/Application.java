package com.javarush.Alymov;

import com.javarush.Alymov.controllers.MainController;
import com.javarush.Alymov.entity.Result;
import com.javarush.khmelov.exception.AppException;

import java.util.Arrays;

public class Application {

    private final MainController mainController;
    public Application(){

        mainController = new MainController();

    }

    public Result run(String[] args) {
        if (args.length>0) {
            String action = args [0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainController.doAction(action, parameters);
        } else {
            throw new AppException("no args");
        }
    }
}
