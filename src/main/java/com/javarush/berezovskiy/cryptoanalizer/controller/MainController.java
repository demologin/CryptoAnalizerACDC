package com.javarush.berezovskiy.cryptoanalizer.controller;

import com.javarush.berezovskiy.cryptoanalizer.command.Action;
import com.javarush.berezovskiy.cryptoanalizer.entity.Result;
import com.javarush.berezovskiy.cryptoanalizer.entity.ResultCode;
import com.javarush.berezovskiy.cryptoanalizer.exception.AppException;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = ActionContainer.get(actionName);
        try {
            return action.execute(parameters);
        } catch (NumberFormatException | AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
