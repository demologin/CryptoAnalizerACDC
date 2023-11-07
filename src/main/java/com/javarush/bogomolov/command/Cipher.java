package com.javarush.bogomolov.command;

import com.javarush.bogomolov.application.Messages;
import com.javarush.bogomolov.constants.Alphabet;
import com.javarush.bogomolov.exception.AppException;
import com.javarush.bogomolov.util.PathBuilder;


import java.io.*;
import java.nio.file.Path;


public class Cipher {
    public void encrypt(String sourceFile, String destFile, int key) {
        Path source = PathBuilder.get(sourceFile);
        Path destination = PathBuilder.get(destFile);
        try (
                FileReader reader = new FileReader(String.valueOf(source));
                FileWriter writer = new FileWriter(String.valueOf(destination))) {
            int length = Alphabet.CHARS.length;
            int value;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);
                if (Alphabet.index.containsKey(character)) {
                    Integer index = Alphabet.index.get(character);
                    index = (index + key + Math.abs(key) * length) % length;
                    writer.write(Alphabet.CHARS[index]);
                } else if (character == '\n') {
                    writer.write(character);
                }

            }


        } catch (IOException e) {
            throw new AppException(Messages.INCORRECT_PATH + e.getMessage(), e);
        }

    }

    public void decrypt(String sourceFile, String destFile, int key) {
        encrypt(sourceFile, destFile, -1 * key);

    }

}


