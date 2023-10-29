package com.javarush.khasanov.controller;

import com.javarush.khasanov.command.Action;
import com.javarush.khasanov.entity.*;
import com.javarush.khmelov.exception.AppException;

public class MainController {
    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.get(actionName);
        try {
            return action.execute(parameters);
        } catch (AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}