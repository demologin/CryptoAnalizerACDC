package com.javarush.kotovych.commands;

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
        boolean isFound = false;
        while (reader.ready()){
            String line = reader.readLine();
            int counter = 0;
                String decodedCharLine = decodeFromString(line, validKey);
                if (isValid(decodedCharLine)) {
                    isFound = true;
                    writer.write(decodedCharLine);

                }
                if (!isFound) {
                    validKey++;
                    counter++;
                }
                if(counter > RuAlphabet.CHARS.length){
                    break;
                }
        }
        if(!isFound){
            throw new RuntimeException("Can't find a valid key");
        }
    }


    private boolean isValid(String text){
        String[] words = text.split(" ");
        char[] chars = text.toCharArray();
        boolean containsWord = false;
        boolean nLettersInARow = false;
        for(String word : words){
            if(RuAlphabet.words.contains(word)){
                containsWord = true;
                break;
            }
            if(threeInARow(word)){
                nLettersInARow = true;
                break;
            }
        }
        char mostFrequentChar = mostFrequentChar(chars);
        if(containsWord){
            return true;
        } else if(mostFrequentChar == RuAlphabet.mostFrequentLetter && !nLettersInARow){
            return true;
        } else if(RuAlphabet.mostFrequentChars.contains(mostFrequentChar) && !nLettersInARow){
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

    private boolean threeInARow(String word){
        String regex = "[" + RuAlphabet.consonants + "]{3}";
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
        return false;
    }
}
