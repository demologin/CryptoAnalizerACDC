package com.javarush.krylov.Service;

import java.util.List;

public class LanguageChecker {

    public String getLanguageByPattern(String text) {
        String languageName = "";
        List<Pattern> languagePatterns = List.of(Pattern.values());
        for(Pattern currentPattern: languagePatterns) {
            if(isPatternWordInText(text, currentPattern)) {
                languageName = currentPattern.getLabel();
            }
        }
        return languageName;
    }

    private boolean isPatternWordInText (String text, Pattern pattern) {

        String [] frequentWords = pattern.getDescription();
        int count = 0;
        for(String word: frequentWords) {
            int wordCount = getFrequentWordCount(text, word);
            if(wordCount > 1) {
                count++;
            }
        }
        return count > 1;
    }

    private int getFrequentWordCount(String text, String frequentWord) {
        int count = 0;
        int index = text.indexOf(frequentWord);
        while (index != -1) {
            count++;
            index = text.indexOf(frequentWord, index + 1);
        }
        return count;
    }
}
