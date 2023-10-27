package com.javarush.khasanov.command;

import com.javarush.khasanov.constant.*;
import com.javarush.khasanov.entity.*;
import com.javarush.khasanov.exception.*;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class Decrypt implements Action{
    @Override
    public Result execute(String[] parameters) {
        Path sourceText = Path.of(DefaultPath.TXT_FOLDER + parameters[0]);
        Path targetText = Path.of(DefaultPath.TXT_FOLDER + parameters[1]);
        int key = Integer.parseInt(parameters[2]);

        try (
                BufferedReader reader = Files.newBufferedReader(sourceText);
                BufferedWriter writer = Files.newBufferedWriter(targetText)
        ) {
            while (reader.ready()) {
                char sourceChar = (char) reader.read();
                int indexSourceChar = getIndexSourceChar(sourceChar);
                if (indexSourceChar < 0) {
                    writer.write(sourceChar);
                    continue;
                }
                int offsetChar = getOffsetChar(indexSourceChar, key);
                writer.write(offsetChar);
            }

        } catch (IOException e) {
            throw new AppException(e);
        }

        return new Result(ResultCode.OK, "Decrypt called");
    }

    private int getIndexSourceChar(char sourceChar) {
        sourceChar = Character.toLowerCase(sourceChar);
        return Arrays.binarySearch(Alphabet.ALPHABET, sourceChar);
    }

    private char getOffsetChar(int indexSourceChar, int key) {
        int resultIndex = (indexSourceChar - key) % Alphabet.ALPHABET.length;
        if (resultIndex < 0) {
            resultIndex += Alphabet.ALPHABET.length;
        }
        return Alphabet.ALPHABET[resultIndex];
    }
}
