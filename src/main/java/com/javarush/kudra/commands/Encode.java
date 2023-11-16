package com.javarush.kudra.commands;

import com.javarush.kudra.Result;
import com.javarush.kudra.commands.AbstractActions;

public class Encode extends AbstractActions {
    @Override
    public Result execute(String[] parameters) {
        String sourceFile = parameters[0];
        String encodedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return runWithKey(sourceFile,encodedFile,key);
    }
}
