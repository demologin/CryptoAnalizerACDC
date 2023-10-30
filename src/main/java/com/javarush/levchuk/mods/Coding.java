package com.javarush.levchuk.mods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.levchuk.constant.Alphabet.*;

public interface Coding {
    public static void processingToFile(Path source, Path target, int key){
        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {
            int numberChar;
            while ((numberChar = reader.read()) > -1) {
                char charByNumber =Character.toLowerCase ((char) numberChar);
                if (alphabetMap.containsKey(charByNumber)) {
                    charByNumber = Character.toLowerCase(charByNumber);
                    int index = getIndexByChar(charByNumber);
                    index = (getAlphabetSize() + (index + key)) % getAlphabetSize();
                    writer.write(getChar(index));
                } else if (!alphabetMap.containsKey(charByNumber)){
                    writer.write(charByNumber);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}