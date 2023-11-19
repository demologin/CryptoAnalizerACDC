package com.javarush.kudra.commands;

import com.javarush.kudra.Execution;
import com.javarush.kudra.PathBuilder;
import com.javarush.kudra.Result;
import com.javarush.kudra.constants.Alphabet;
import com.javarush.kudra.exceptions.IncorrectFileNameException;
import com.javarush.kudra.constants.Constant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractActions implements Execution {
    public Result changeWithKey(String sourceFile, String destFile, int key)  {
        Path sourceFileName = PathBuilder.getAbsoluteName(sourceFile);
        Path destFileName = PathBuilder.getAbsoluteName(destFile);
       try (BufferedReader bufferedReader = Files.newBufferedReader(sourceFileName);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(destFileName)){
           int symbol;
           while ((symbol=bufferedReader.read())>-1){
               char character = (char) symbol;
               character = Character.toLowerCase(character);
               if (!Alphabet.SYMBOLS_CHAR.containsKey(character)){
                   continue;
               }
               Integer positionNumber = Alphabet.SYMBOLS_CHAR.get(character);
               int searchedNumber = (positionNumber+key+Math.abs(key)*Alphabet.SIZE)%Alphabet.SIZE;
               bufferedWriter.write(Alphabet.ALPHABET[searchedNumber]);
           }
       }
       catch (IOException e){
           throw new IncorrectFileNameException(Constant.INCORRECT_FILE_NAME, e);
       }

    return new Result();
    }



}
