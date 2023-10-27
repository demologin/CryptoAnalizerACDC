package com.javarush.alimova.commands;

import com.javarush.alimova.controller.CommandContainer;
import com.javarush.alimova.dictionary.Alphabet;
import com.javarush.alimova.dictionary.Const;
import com.javarush.alimova.exception.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class StaticAnalyzer extends Coding{

    @Override
    protected int getIndex(int index, int key) {
        return 0;
    }

    @Override
    protected Result getResult(Path inputFile, Path outputFile) {
        return new Result(true, CommandContainer.ANALYZER, inputFile, outputFile);
    }

    @Override
    protected void codingText(String[] parameters) {

        Path input = getPathToFile(parameters[0]);
        Path output = getPathToFile(parameters[1]);
        Path pathSource = getPathToFile(parameters[2]);

        try {
            Files.deleteIfExists(output);
            Files.createFile(output);
        } catch (IOException e) {
            throw new AppException(Const.ERROR_FILE + ": " + e.getMessage(), e);
        }

        long[] freqArraySource = countingFreq(pathSource);
        long[] freqArrayText = countingFreq(input);

        Map<Character, Character> compareAlphabet = compareFreq(freqArrayText, freqArraySource);

        try (BufferedReader reader = Files.newBufferedReader(input);
             BufferedWriter writer = Files.newBufferedWriter(output, StandardOpenOption.WRITE)) {
            int symbol;
            while((symbol = reader.read()) > -1) {
                char value = (char)Character.toLowerCase(symbol);
                if (!Alphabet.symbol.containsKey(value)) {
                    continue;
                }
                writer.write(compareAlphabet.get(value));
            }

        }
        catch (IOException e) {
            throw new AppException(Const.ERROR_FILE + ": " + e.getMessage(), e);

        }

    }

    private long[] countingFreq(Path inputFile) {
        long[] freqArray = new long[Alphabet.CHARS.length];
        Arrays.fill(freqArray, 0);
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
                freqArray[i] = freqArray[i]/ (sizeText / 5000);
            }

        }
        catch (IOException e) {
            throw new AppException(Const.ERROR_FILE + ": " + e.getMessage(), e);

        }
        return freqArray;
    }

    private Map<Character, Character> compareFreq(long[] freqArrayText, long[] freqArraySource) {
        List<Map.Entry<Character, Long>> charFrequencySource = new ArrayList<>();
        List<Map.Entry<Character, Long>> charFrequencyText = new ArrayList<>();

        for (int i = 0; i < freqArraySource.length; i++) {
            charFrequencySource.add(new AbstractMap.SimpleEntry<>(Alphabet.CHARS[i], freqArraySource[i]));
        }

        charFrequencySource.sort(Map.Entry.comparingByValue());

        for (int i = 0; i < freqArrayText.length; i++) {
            charFrequencyText.add(new AbstractMap.SimpleEntry<>(Alphabet.CHARS[i], freqArrayText[i]));
        }

        charFrequencyText.sort(Map.Entry.comparingByValue());

        Map<Character, Character> compareAlphabet = new HashMap<>();

        for (int i = 0; i < Alphabet.CHARS.length; i++) {
            Character inputChar = charFrequencyText.get(i).getKey();
            Character outputChar = charFrequencySource.get(i).getKey();
            compareAlphabet.put(inputChar, outputChar);
        }

        return compareAlphabet;

    }
}
