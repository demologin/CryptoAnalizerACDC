package com.javarush.kotovych.commands;

import com.javarush.kotovych.containers.Action;
import com.javarush.kotovych.containers.Alphabet;
import com.javarush.kotovych.exceptions.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BruteForce extends Decoder implements Action {
    @Override
    public String execute(Path input, int key, Path output, Alphabet alphabet){
        int validKey = findValidKey(input, alphabet);
        return super.execute(input, validKey, output, alphabet);
    }

    private int findValidKey(Path input, Alphabet alphabet){
        int key = 0;
        int mostSpaces = 0;
        char[] textAlphabet = alphabet.getChars();
        try(BufferedReader reader = Files.newBufferedReader(input)) {
            StringBuilder builder = new StringBuilder();
            List<String> lines = reader.lines().toList();
            for(String line : lines){
                builder.append(line);
            }
            String text = builder.toString();
            for(int i = 0; i < lines.size(); i++) {
                for (int k = -textAlphabet.length; k < textAlphabet.length; k++) {
                    String decodedLine = decodeString(text, k, alphabet);
                    String[] charLine = decodedLine.split(" ");
                    for (String s : charLine) {
                        if (alphabet.getWords().contains(s)) {
                            return k;
                        }
                    }
                    int spaces = countChar(decodedLine.toCharArray(), ' ');
                    if (spaces > mostSpaces) {
                        mostSpaces = spaces;
                        key = k;
                    }
                }
            }
            return key;
        } catch (IOException e){
            throw new AppException(e);
        }
    }
}
