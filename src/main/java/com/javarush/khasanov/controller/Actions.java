package com.javarush.khasanov.controller;

import com.javarush.khasanov.command.*;
import com.javarush.khasanov.exception.AppException;

import static com.javarush.khasanov.view.Messages.INCORRECT_ACTION_NAME;

public enum Actions {
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action get(String actionName) {
        try {
            Actions found = Actions.valueOf(actionName.toUpperCase());
            return found.action;
        } catch (IllegalArgumentException e) {
            throw new AppException(INCORRECT_ACTION_NAME);
        }
    }
}
