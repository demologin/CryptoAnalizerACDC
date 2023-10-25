package com.javarush.kotovych.commands;

import com.javarush.kotovych.constants.OtherSymbols;
import com.javarush.kotovych.constants.RuAlphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce extends Decoder implements Action{
    @Override
    public void execute(BufferedReader reader, int key, BufferedWriter writer) throws IOException{
        int validKey = 0;
        if(reader.ready()){
            String line = reader.readLine();
            validKey = findValidKey(line);
            writer.write(decodeFromString(line, validKey));
        }

        while (reader.ready()){
            super.execute(reader, validKey, writer);
        }
    }

    private int findValidKey(String text){
        int validKey = 0;
        boolean isFound = false;

        while (!isFound){
            String decodedCharLine = decodeFromString(text, validKey);
            if (isValid(decodedCharLine)) {
                isFound = true;
                return validKey;
            }
            validKey++;
            if(validKey > RuAlphabet.CHARS.length){
                throw new RuntimeException("Unable to find a key");
            }
        }
        return -1;
    }


    private boolean isValid(String text){
        String[] words = text.split(" ");
        char[] chars = text.toCharArray();
        boolean containsWord = false;
        boolean nLettersInARow = false;
        boolean isAWord = false;
        for(String word : words){
            if(RuAlphabet.words.contains(word)){
                containsWord = true;
                break;
            }
            if(nInARow(word, 3)){
                nLettersInARow = true;
                break;
            }
            if(isValidWord(word)){
                isAWord = true;
                break;
            }
        }
        char mostFrequentChar = mostFrequentChar(chars);
        if(containsWord){
            return true;
        } else if(mostFrequentChar == RuAlphabet.mostFrequentLetter && !nLettersInARow && isAWord){
            return true;
        } else if(RuAlphabet.mostFrequentChars.contains(mostFrequentChar) && !nLettersInARow && isAWord){
            return true;
        } else {
            return false;
        }
    }

    private char mostFrequentChar(char[] chars){
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : chars) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        char mostRepeated = 0;
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostRepeated = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostRepeated;
    }

    private boolean nInARow(String word, int n){
        String regex = String.format("[" + RuAlphabet.consonants + "]{%d}", n);
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(word);

        while (matcher.find()) {
            String match = matcher.group();
            if (!isValidWord(match)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidWord(String word){
        if(!(containsCharacter(word, (OtherSymbols.NUMBERS + OtherSymbols.SYMBOLS).toCharArray()))){
            return true;
        }
        return false;
    }

    private boolean containsCharacter(String word, char[] chars){
        for(char c: chars){
            if(word.contains(String.valueOf(c))){
                return true;
            }
        }
        return false;
    }
}
