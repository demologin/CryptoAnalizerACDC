package com.javarush.kotovych.commands;

import com.javarush.kotovych.exceptions.AppException;

import java.io.BufferedReader;
import java.nio.file.Files;
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
            String text = builder.toString();
            return text;
        } catch (Exception e){
            throw new AppException(e);
        }
    }
}
