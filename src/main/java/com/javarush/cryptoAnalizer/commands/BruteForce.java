package com.javarush.cryptoAnalizer.commands;

import com.javarush.cryptoAnalizer.files.FileProcessor;
import com.javarush.cryptoAnalizer.menu.MenuValues;

public class BruteForce extends FileProcessor {
    @Override
    public void runFile() {
        MenuValues parameters = DefineAction.getParameters();
        String sourceFile = parameters.getSourceFile();
        String destFile = parameters.getDestFile();
        String bruteforceFile = parameters.getKey();

        runBruteForce(sourceFile,destFile,bruteforceFile, FileActionEnum.BRUTEFORCE);
    }
}
