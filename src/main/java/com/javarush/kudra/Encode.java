package com.javarush.kudra;

public class Encode extends AbstractActions {
    @Override
    public Result execute(String[] parameters) {
        String sourceFile = parameters[0];
        String encodedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return runWithKey(sourceFile,encodedFile,key);
    }
}
