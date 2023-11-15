package com.javarush.kudra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractActions implements Execution {
    Result runWithKey(String sourceFile, String destFile, int key)  {
        Path sourceFileName = PathBuilder.getAbsoluteName(sourceFile);
        Path destFileName = PathBuilder.getAbsoluteName(destFile);
       try (BufferedReader bufferedReader = Files.newBufferedReader(sourceFileName);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(destFileName)){

       }
       catch (IOException e){
           throw new UncorrectFileNameException(e);
       }

    return null;
    }



}
