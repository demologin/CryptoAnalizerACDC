package com.javarush.levchuk.mods.tools;

import com.javarush.levchuk.constant.Alphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static com.javarush.levchuk.constant.Alphabet.*;

public abstract class Coding {
    public static void processingToFile(Path source, Path target, int key){
        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {
            int numberChar;
            while ((numberChar = reader.read()) > -1) {
                char charByNumber = Character.toLowerCase((char) numberChar);
                writer.write(charEncryptor(charByNumber,key));
            }
        }catch (NoSuchFileException e) {
            System.err.println("Incorrect file path has been entered");
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static char charEncryptor(char character, int key){
        if (alphabetMap.containsKey(character)) {
            int index = getIndexByChar(character);
            index = (getAlphabetSize() * Math.abs(key) + (index + key)) % getAlphabetSize();
            return Alphabet.getChar(index);
        }
        return character;
    }
}