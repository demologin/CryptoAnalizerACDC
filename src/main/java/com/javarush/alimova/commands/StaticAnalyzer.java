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
    protected void codingText(Path input, Path output, String[] parameters) {

        //здесь реализован примитивный метод сопоставления частот, возможно, можно сделать лучше

        Path pathSource = Path.of(System.getProperty("user.dir"), "text", parameters[2]);

        List<Map.Entry<Character, Long>> charFrequencySource = new ArrayList<>();
        List<Map.Entry<Character, Long>> charFrequencyText = new ArrayList<>();
        //пригодится для сопоставления частот

        //частоты будем считать через обычный массив (тоже этот кусок можно вынести в один код)
        //----
        long[] freqArraySource = new long[Alphabet.CHARS.length];
        Arrays.fill(freqArraySource, 0);
        long sizeTextSource = countingFreq(pathSource, freqArraySource);

        for (int i = 0; i < freqArraySource.length; i++) {
            charFrequencySource.add(new AbstractMap.SimpleEntry<>(Alphabet.CHARS[i], freqArraySource[i] / (sizeTextSource / 5000)));
        }

        charFrequencySource.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Character, Long> map:
                charFrequencySource) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

        //------


        long[] freqArrayText = new long[Alphabet.CHARS.length];
        Arrays.fill(freqArrayText, 0);
        long sizeTextFile = countingFreq(input, freqArrayText);

        for (int i = 0; i < freqArrayText.length; i++) {
            charFrequencyText.add(new AbstractMap.SimpleEntry<>(Alphabet.CHARS[i], freqArrayText[i] / (sizeTextFile / 5000)));
        }

        charFrequencyText.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Character, Long> map:
                charFrequencyText) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

        //для быстроты замены
        Map<Character, Character> changeAlphabet = new HashMap<>();

        for (int i = 0; i < Alphabet.CHARS.length; i++) {
            Character inputChar = charFrequencyText.get(i).getKey();
            Character outputChar = charFrequencySource.get(i).getKey();
            changeAlphabet.put(inputChar, outputChar);
        }

        for (Map.Entry<Character, Character> map:
                changeAlphabet.entrySet()) {
            System.out.println(map.getKey() + " -> " + map.getValue());
        }

        try (BufferedReader reader = Files.newBufferedReader(input);
             BufferedWriter writer = Files.newBufferedWriter(output, StandardOpenOption.WRITE)) {
            int symbol;
            while((symbol = reader.read()) > -1) {
                char value = (char)Character.toLowerCase(symbol);
                if (!Alphabet.symbol.containsKey(value)) {
                    continue;
                }
                writer.write(changeAlphabet.get(value));
            }

        }
        catch (IOException e) {
            throw new AppException(Const.ERROR_FILE + ": " + e.getMessage(), e);

        }
        //super.codingText(input, output, parameters);
    }

    private long countingFreq(Path inputFile, long[] freqArray) {
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

        }
        catch (IOException e) {
            throw new AppException(Const.ERROR_FILE + ": " + e.getMessage(), e);

        }
        return sizeText;
    }
}
