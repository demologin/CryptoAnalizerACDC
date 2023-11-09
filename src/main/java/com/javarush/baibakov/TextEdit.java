package com.javarush.baibakov;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextEdit {

    private List<Character> textSource = new ArrayList();
    private List<Character> textTarget = new ArrayList();


    public char shiftChar(char character, int key, char[] chars) {
        char resultChar = ' ';
        for (int i = 0; i < chars.length; i++) {
            if (character == chars[i]) {
                if (chars.length < i + key) {
                    resultChar = chars[i + key - chars.length];
                } else if (0 > i + key) {
                    resultChar = chars[chars.length + i + key];
                } else {
                    resultChar = chars[i + key];
                }
            }
        }
        return resultChar;
    }

    public void editText(int key,char[] chars) {
        for (int i=0;i<this.textSource.size();i++){
            textTarget.add(i,shiftChar(this.textSource.get(i),key,chars));
        }
    }



    public void getTextSource(String source) {
        Path pathSource = Paths.get(source);
        try (BufferedReader reader = Files.newBufferedReader(pathSource)) {
            int i = 0;
            while (reader.ready()) {
                char character = (char) reader.read();
                character = Character.toLowerCase(character);
                textSource.add(i, character);
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void setTextTarget(String target) {
        Path pathTarget = Paths.get(target);
        try (BufferedWriter writer = Files.newBufferedWriter(pathTarget)) {
            for (int i = 0; i < textTarget.size(); i++) {
                writer.write(textTarget.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
