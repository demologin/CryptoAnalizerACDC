package com.javarush.Alymov.controllers;

import com.javarush.Alymov.comands.Action;
import com.javarush.Alymov.comands.Decoder;
import com.javarush.Alymov.comands.Encoder;
import com.javarush.khmelov.exception.AppException;

public enum ActionFactory {
    ENCODE(new Encoder()),
    DECODE(new Decoder());
    private final Action action;
    ActionFactory(Action actionFactory) {
        this.action = actionFactory;
    }
    public static Action find(String actionName){
        try {
            ActionFactory value = ActionFactory.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e ){
            throw new AppException("not found "+ actionName, e);
        }
    }
}
