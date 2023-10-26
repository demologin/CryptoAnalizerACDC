package com.javarush.kotovych.commands;

import com.javarush.kotovych.constants.RuAlphabet;
import com.javarush.kotovych.exceptions.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encoder extends CipherMethods implements Action{
    @Override
    public String execute(Path input, int key, Path output){
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(input);
        BufferedWriter writer = Files.newBufferedWriter(output)) {
            char[] alphabet = RuAlphabet.CHARS;
            while (reader.ready()) {
                char[] line = reader.readLine().toLowerCase().toCharArray();
                for (int i = 0; i < line.length; i++) {
                    int position = findPosition(alphabet, line[i]);
                    if (position != -1) {
                        line[i] = alphabet[(position + key + alphabet.length) % alphabet.length];
                    }
                }
                builder.append(new String(line) + '\n');
                writer.write(new String(line) + '\n');
            }
        } catch (IOException e){
            throw new AppException(e);
        }
        return builder.toString();
    }

    public String encodeString(String text, int key){
        char[] alphabet = RuAlphabet.CHARS;
        char[] str = text.toCharArray();

        for (int i = 0; i < str.length; i++) {
            int position = findPosition(alphabet, str[i]);
            if(position != -1){
                str[i] = alphabet[(position + key + alphabet.length) % alphabet.length];
            }
        }
        return new String(str);
    }
}
