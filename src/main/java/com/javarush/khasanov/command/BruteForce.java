package com.javarush.khasanov.command;

import com.javarush.khasanov.constant.*;
import com.javarush.khasanov.entity.*;
import com.javarush.khasanov.exception.AppException;
import com.javarush.khasanov.view.*;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

import static com.javarush.khasanov.util.PathBuilder.getPath;
import static com.javarush.khasanov.view.Messages.INCORRECT_FILE;

public class BruteForce implements Action {
    @Override
    public Result execute(String[] parameters) {
        Path sourceText = getPath(parameters[0]);
        Path targetText = getPath(parameters[1]);

        int bestKey = 0;
        int maxNumberSpaces = 0;

        for (int key = 1; key <= Alphabet.ALPHABET.length; key++) {
            int numberSpaces = decryptByKey(sourceText, targetText, key);
            if (numberSpaces > maxNumberSpaces) {
                maxNumberSpaces = numberSpaces;
                bestKey = key;
            }
        }

        decryptByKey(sourceText, targetText, bestKey);

        return new Result(ResultCode.OK, Messages.OPERATION_COMPLETE);
    }

    private int decryptByKey(Path sourceText, Path targetText, int key) {
        int numberSpaces = 0;

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

                if (Character.isSpaceChar(offsetChar)) {
                    numberSpaces++;
                }
            }
        } catch (IOException e) {
            throw new AppException(INCORRECT_FILE);
        }

        return numberSpaces;
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
