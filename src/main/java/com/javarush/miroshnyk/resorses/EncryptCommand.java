package com.javarush.miroshnyk.resorses;

import com.javarush.miroshnyk.Runner;
import com.javarush.miroshnyk.utiles;

import java.nio.file.Path;

public class EncryptCommand {

    public static void execute() {
        ConsoleHelper.print("Encrypting");
        Runner.textFileName = ConsoleHelper.askFilename("Please, put file name from where read the text");
        Runner.encryptedFileName = ConsoleHelper.askFilename("Please, put file name where to save encrypted text");
        utiles.createFile(Runner.encryptedFileName);
        Runner.cipherKey = ConsoleHelper.askCipherKey("Please, put encryption key");
        utiles.readFile(Path.of(Runner.directoryPathForWorkFileSave + Runner.textFileName), Runner.mainBufferString);
        utiles.encript(Runner.cipherKey, Runner.mainBufferString);
        utiles.writeFile(Path.of(Runner.directoryPathForWorkFileSave + Runner.encryptedFileName), Runner.mainBufferString);
    }
}
