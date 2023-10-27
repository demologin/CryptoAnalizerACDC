package com.javarush.kotovych.commands;

import com.javarush.kotovych.containers.Action;
import com.javarush.kotovych.containers.Alphabet;
import com.javarush.kotovych.exceptions.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce extends Decoder implements Action {
    @Override
    public String execute(Path input, int key, Path output, Alphabet alphabet){
        int validKey = findValidKey(input, alphabet);
        return super.execute(input, validKey, output, alphabet);
    }

    private int findValidKey(Path input, Alphabet alphabet){
        int key;
        int mostSpaces = 0;
        char[] textAlphabet = alphabet.getChars();
        try(BufferedReader reader = Files.newBufferedReader(input)) {
            String line = reader.readLine();
            for (key = -textAlphabet.length; key < textAlphabet.length; key++) {
                String decodedLine = decodeString(line, key, alphabet);
                String[] charLine = decodedLine.split(" ");
                for(String s : charLine){
                    if(alphabet.getWords().contains(s)){
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
