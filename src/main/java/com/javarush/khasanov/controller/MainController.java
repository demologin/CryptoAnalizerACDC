package com.javarush.khasanov.controller;

import com.javarush.khasanov.command.Action;
import com.javarush.khasanov.entity.*;
import com.javarush.khasanov.exception.*;


public class MainController {
    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.get(actionName);
        try {
            return action.execute(parameters);
        } catch (NumberFormatException | AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}