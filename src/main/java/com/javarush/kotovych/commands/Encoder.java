package com.javarush.kotovych.commands;

import com.javarush.kotovych.containers.Action;
import com.javarush.kotovych.containers.Alphabet;
import com.javarush.kotovych.exceptions.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encoder extends CipherMethods implements Action {
    @Override
    public String execute(Path input, int key, Path output, Alphabet alphabet){
        StringBuilder builder = new StringBuilder();
        char[] textAlphabet = alphabet.getChars();
        try(BufferedReader reader = Files.newBufferedReader(input);
        BufferedWriter writer = Files.newBufferedWriter(output)) {
            while (reader.ready()) {
                String line = reader.readLine();
                char[] charLine = line.toLowerCase().toCharArray();
                for (int i = 0; i < charLine.length; i++) {
                    int position = findPosition(textAlphabet, charLine[i]);
                    if (position > -1) {
                        int positionToReplace = (position + key + textAlphabet.length) % textAlphabet.length;
                        charLine[i] = textAlphabet[positionToReplace];
                    }
                }
                builder.append(new String(charLine)).append('\n');
                writer.write(new String(charLine));
            }
        } catch (IOException e){
            throw new AppException(e);
        }
        return builder.toString();
    }

    public String encodeString(String text, int key, Alphabet alphabet){
        char[] textAlphabet = alphabet.getChars();
        char[] str = text.toCharArray();

        for (int i = 0; i < str.length; i++) {
            int position = findPosition(textAlphabet, str[i]);
            if(position > -1){
                str[i] = textAlphabet[(position + key + textAlphabet.length) % textAlphabet.length];
            }
        }
        return new String(str);
    }
}
