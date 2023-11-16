package com.javarush.khasanov.command;

import com.javarush.khasanov.constant.*;
import com.javarush.khasanov.entity.*;
import com.javarush.khasanov.exception.*;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

import static com.javarush.khasanov.util.PathBuilder.getPath;
import static com.javarush.khasanov.view.Messages.*;

public class Decrypt implements Action{
    @Override
    public Result execute(String[] parameters) {
        Path sourceText = getPath(parameters[0]);
        Path targetText = getPath(parameters[1]);

        try (
                BufferedReader reader = Files.newBufferedReader(sourceText);
                BufferedWriter writer = Files.newBufferedWriter(targetText)
        ) {
            int key = Integer.parseInt(parameters[2]);
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

        } catch (NumberFormatException e) {
            throw new AppException(INCORRECT_KEY);
        } catch (IOException e) {
            throw new AppException(INCORRECT_FILE);
        }

        return new Result(ResultCode.OK, OPERATION_COMPLETE);
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
