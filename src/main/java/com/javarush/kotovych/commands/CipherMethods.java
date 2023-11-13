package com.javarush.kotovych.commands;

import com.javarush.kotovych.constants.Constants;
import com.javarush.kotovych.exceptions.AppException;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.*;

public abstract class CipherMethods {
    public int findPosition(char[] chars, char symbol){
        return Arrays.binarySearch(chars, symbol);
    }

    public String getTextFromFile(Path path){
        try(BufferedReader reader = Files.newBufferedReader(path)){
            StringBuilder builder = new StringBuilder();
            List<String> lines = reader.lines().toList();
            for(String line : lines){
                builder.append(line).append('\n');
            }
            return builder.toString();
        } catch (NoSuchFileException e){
            throw new AppException(Constants.FILE_DOES_NOT_EXIST_EXCEPTION_TEXT, e);
        } catch (Exception e){
            throw new AppException(e.getMessage(), e);
        }
    }
}
