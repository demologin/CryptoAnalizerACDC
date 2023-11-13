package com.javarush.berezovskiy.commands;


import com.javarush.berezovskiy.files.FileProcessor;
import com.javarush.berezovskiy.menu.MenuValues;

public class Encrypt extends FileProcessor {
    @Override
    public void runFile() {
        MenuValues parameters = DefineAction.getParameters();
        String sourceFile = parameters.getSourceFile();
        String destFile = parameters.getDestFile();
        int key = Integer.parseInt(parameters.getKey());

        runFileWithKey(sourceFile,destFile,key, FileActionEnum.ENCRYPTED);
    }

}
