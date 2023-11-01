package com.javarush.bogomolov.command;

import com.javarush.bogomolov.constants.Alphabet;



import java.io.*;


public class Cipher {
    public void encrypt(String sourceFile, String destFile, int offset) {
        //Path source = PathBuilder.get(sourceFile);
        //Path destination = PathBuilder.get(destFile);
        try (
                FileReader reader =new FileReader(sourceFile);
                FileWriter writer = new FileWriter(destFile)) {
            int length = Alphabet.CHARS.length;
            int value;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);
                if (Alphabet.index.containsKey(character)) {
                    Integer index = Alphabet.index.get(character);
                    index = (index + offset + Math.abs(offset) * length) % length;
                    writer.write(Alphabet.CHARS[index]);
                } else if (character == '\n') {
                    writer.write(character);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void decrypt(String sourceFile, String destFile, int offset) {
        encrypt(sourceFile, destFile, -1 * offset);

    }

}


