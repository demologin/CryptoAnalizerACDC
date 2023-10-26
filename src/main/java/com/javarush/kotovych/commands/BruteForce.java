package com.javarush.kotovych.commands;

import com.javarush.kotovych.constants.RuAlphabet;
import com.javarush.kotovych.exceptions.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce extends Decoder implements Action{
    @Override
    public String execute(Path input, int key, Path output){
        int validKey = findValidKey(input);
        return super.execute(input, validKey, output);
    }

    private int findValidKey(Path input){
        int key;
        int mostSpaces = 0;
        try(BufferedReader reader = Files.newBufferedReader(input)) {
            for (key = -RuAlphabet.CHARS.length; key < RuAlphabet.CHARS.length; key++) {
                String line = reader.readLine();
                String decodedLine = decodeString(line, key);
                String[] charLine = decodedLine.split(" ");
                for(String s : charLine){
                    if(RuAlphabet.words.contains(s)){
                        return key;
                    }
                }
                int spaces = countChar(decodedLine.toCharArray(), ' ');
                if(spaces > mostSpaces){
                    mostSpaces = spaces;
                }
            }
            return key;
        } catch (IOException e){
            throw new AppException(e);
        }
    }
}
