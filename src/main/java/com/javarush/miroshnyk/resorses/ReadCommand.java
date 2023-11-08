package com.javarush.miroshnyk.resorses;

import com.javarush.miroshnyk.Runner;
import com.javarush.miroshnyk.utiles;

import java.nio.file.Path;

public class ReadCommand {
    public static void execute() {
            ConsoleHelper.print("Reading");
            Runner.textFileName = ConsoleHelper.askFilename("Please, enter file name for reading");
            utiles.readFile(Path.of(Runner.directoryPathForWorkFileSave+ Runner.textFileName), Runner.mainBufferString);
            for (String str :
                    Runner.mainBufferString) {
                ConsoleHelper.print(str);
            }

    }
}
