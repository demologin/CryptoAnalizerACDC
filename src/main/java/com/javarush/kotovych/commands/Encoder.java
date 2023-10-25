package com.javarush.kotovych.commands;

import com.javarush.kotovych.constants.RuAlphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class Encoder extends CipherMethods implements Action{
    @Override
    public void execute(BufferedReader reader, int key, BufferedWriter writer) throws IOException{
        char[] alphabet = RuAlphabet.CHARS;
        while (reader.ready()){
            char[] line = reader.readLine().toLowerCase().toCharArray();
            for (int i = 0; i < line.length; i++) {
                int position = findPosition(alphabet, line[i]);
                if(position != -1) {
                    line[i] = alphabet[(position + key + alphabet.length) % alphabet.length];
                }
            }
            writer.write(new String(line) + '\n');
        }
    }

    public String encodeString(String text, int key){
        char[] alphabet = RuAlphabet.CHARS;
        char[] str = text.toCharArray();

        for (int i = 0; i < str.length; i++) {
            int position = findPosition(alphabet, str[i]);
            if(position != -1){
                str[i] = alphabet[(position + key + alphabet.length) % alphabet.length];
            } else {
                str[i] = ' ';
            }
        }
        return new String(str);
    }
}
