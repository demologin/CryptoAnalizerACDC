package com.javarush.Alymov.controllers;

import com.javarush.Alymov.comands.Action;
import com.javarush.Alymov.entity.Result;

public class MainController {
    public Result doAction(String actionName, String[] parametrs) {
        Action action = ActionFactory.find(actionName);
        return action.execute(parametrs);
    }
}
