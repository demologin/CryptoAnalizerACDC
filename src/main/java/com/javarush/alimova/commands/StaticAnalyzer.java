package com.javarush.alimova.commands;

import com.javarush.alimova.controller.CommandContainer;
import com.javarush.alimova.dictionary.Alphabet;
import com.javarush.alimova.dictionary.Const;
import com.javarush.alimova.exception.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StaticAnalyzer extends Coding{

    private int keyCoding = -1;
    @Override
    protected int getIndex(int index, int key) {
        if (index - key < 0) {
            return Alphabet.CHARS.length + (index - key);
        }
        return index - key;
    }

    @Override
    protected Result getResult(Path inputFile, Path outputFile) {
        return new Result(true, CommandContainer.ANALYZER, inputFile, outputFile, keyCoding);
    }

    @Override
    protected void codingText(String[] parameters) {

        Path input = Path.of(System.getProperty("user.dir"), "text", parameters[0]);
        Path pathSource = Path.of(System.getProperty("user.dir"), "text", parameters[2]);

        int validKey = keySelection(input, pathSource);
        keyCoding = validKey;
        super.codingText(new String[]{parameters[0], parameters[1], String.valueOf(validKey)});

    }

    private void countingFreq(Path inputFile, long[] freqArray) {
        long sizeText = 0;
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            int symbol;
            while((symbol = reader.read()) > -1) {
                char value = (char)Character.toLowerCase(symbol);
                if (!Alphabet.symbol.containsKey(value)) {
                    continue;
                }
                int index = Alphabet.symbol.get(value);
                freqArray[index]++;
                sizeText++;
            }

            for (int i = 0; i < freqArray.length; i++) {
                freqArray[i] = freqArray[i] / (sizeText / 1000);
            }

        }
        catch (IOException e) {
            throw new AppException(Const.ERROR_FILE + ": " + e.getMessage(), e);

        }
    }

    private double avgSquaredDeviation(long[] freqArrayText, long[] freqArraySource) {
        double avgSql = 0;
        for (int i = 0; i < freqArrayText.length; i++) {
            double value = freqArraySource[i] - freqArrayText[i];
            avgSql += value * value;
        }
        avgSql /= freqArrayText.length;
        return avgSql;
    }

    private void shiftArray(long[] freqArray) {
        long tmp = freqArray[0];
        for (int i = 0; i < freqArray.length - 1; i++) {
            freqArray[i] = freqArray[i + 1];
        }
        freqArray[freqArray.length - 1] = tmp;
    }

    private int keySelection(Path pathInput, Path pathSource) {
        int validKey = 0;

        long[] freqArraySource = new long[Alphabet.SIZE];
        Arrays.fill(freqArraySource, 0);
        countingFreq(pathSource, freqArraySource);

        long[] freqArrayText = new long[Alphabet.SIZE];
        Arrays.fill(freqArrayText, 0);
        countingFreq(pathInput, freqArrayText);

        double minDeviation = avgSquaredDeviation(freqArrayText, freqArraySource);

        for (int i = 1; i < Alphabet.SIZE; i++) {
            shiftArray(freqArrayText);
            double value = avgSquaredDeviation(freqArrayText, freqArraySource);

            if (value < minDeviation) {
                minDeviation = value;
                validKey = i;
            }
        }
        return validKey;
    }
}
