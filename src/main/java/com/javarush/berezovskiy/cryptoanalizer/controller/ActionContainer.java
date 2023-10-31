package com.javarush.berezovskiy.cryptoanalizer.controller;

import com.javarush.berezovskiy.command.*;
import com.javarush.berezovskiy.cryptoanalizer.command.*;
import com.javarush.berezovskiy.cryptoanalizer.constant.Const;
import com.javarush.berezovskiy.cryptoanalizer.exception.AppException;

@SuppressWarnings("unused")
public enum ActionContainer {

    ENCODE(new Encode()),
    DECODE(new Decode()),
    BRUTEFORCE(new BruteForce()),
    ANALYZE(new Analyze()),
    EXIT(new Exit());

    private final Action action;

    ActionContainer(Action action) {
        this.action = action;
    }

    public static Action get(String actionName) {
        try {
            ActionContainer value = ActionContainer.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e) {
            String message = String.format(Const.NOT_FOUND_ACTION_FORMAT, actionName);
            throw new AppException(message, e);
        }
    }
}
