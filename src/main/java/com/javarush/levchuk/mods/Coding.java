package com.javarush.levchuk.mods;

import com.javarush.levchuk.constant.Alphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Map;

import static com.javarush.levchuk.constant.Alphabet.*;

public interface Coding {
    public static void processingToFile(Path source, Path target, int key){
        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {
            int numberChar;
            while ((numberChar = reader.read()) > -1) {
                char charByNumber = Character.toLowerCase((char) numberChar);
                if (alphabetMap.containsKey(charByNumber)) {
                    charByNumber = Character.toLowerCase(charByNumber);
                    int index = getIndexByChar(charByNumber);
                    index = (getAlphabetSize() * Math.abs(key) + (index + key)) % getAlphabetSize();
                    writer.write(getChar(index));

                } else if (!alphabetMap.containsKey(charByNumber)) {
                    writer.write(charByNumber);
                }
            }
        }catch (NoSuchFileException e) {
            System.err.println("Incorrect file path has been entered");
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}