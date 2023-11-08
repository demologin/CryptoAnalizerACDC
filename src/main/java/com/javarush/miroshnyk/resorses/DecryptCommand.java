package com.javarush.miroshnyk.resorses;

import com.javarush.miroshnyk.Runner;
import com.javarush.miroshnyk.utiles;

import java.nio.file.Path;

public class DecryptCommand {

    public static void execute() {
        ConsoleHelper.print("Decrypting");
        Runner.textFileName = ConsoleHelper.askFilename("Please, put file name from where read the text");
        Runner.decryptedFileName = ConsoleHelper.askFilename("Please, put file name where to save decrypted text");
        utiles.createFile(Runner.decryptedFileName);
        Runner.cipherKey = ConsoleHelper.askCipherKey("Please, put encryption key");
        utiles.readFile(Path.of(Runner.directoryPathForWorkFileSave + Runner.textFileName), Runner.mainBufferString);
        utiles.encript(Runner.cipherKey*(-1), Runner.mainBufferString);
        utiles.writeFile(Path.of(Runner.directoryPathForWorkFileSave + Runner.decryptedFileName), Runner.mainBufferString);
    }
}
