package com.javarush.khasanov.controller;

import com.javarush.khasanov.command.*;
import com.javarush.khasanov.exception.AppException;

public enum Actions {
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action get(String actionName) {
        if (!actionName.isBlank()) {
            Actions found = Actions.valueOf(actionName.toUpperCase());
            return found.action;
        }
        throw new AppException("Incorrect action name");
    }
}
