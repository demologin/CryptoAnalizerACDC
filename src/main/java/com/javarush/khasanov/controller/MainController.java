package com.javarush.khasanov.controller;

import com.javarush.khasanov.command.Action;
import com.javarush.khasanov.entity.Result;

public class MainController {
    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.get(actionName);
        return action.execute(parameters);
    }
}