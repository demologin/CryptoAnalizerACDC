package com.javarush.miroshnyk.resorses;

import com.javarush.miroshnyk.Runner;
import com.javarush.miroshnyk.utiles;

import java.nio.file.Path;

import static com.javarush.miroshnyk.Runner.textFileName;

public class ReadCommand{
    public static void execute() {
            ConsoleHelper.print("Reading");
            textFileName = ConsoleHelper.askFilename("Please, enter file name for reading");
            if (!textFileName.equals("exit")){
                utiles.readFile(Path.of(Runner.directoryPathForWorkFileSave+ textFileName), Runner.mainBufferString);
                for (String str :
                        Runner.mainBufferString) {
                    ConsoleHelper.print(str);
                }
            }
    }
}
