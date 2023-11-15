package com.javarush.kudra;

public class Decode extends AbstractActions {
    @Override
    public Result execute(String[] parameters) {
        String encodedFile = parameters[0];
        String decodedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return runWithKey(encodedFile,decodedFile,key);
    }
}
