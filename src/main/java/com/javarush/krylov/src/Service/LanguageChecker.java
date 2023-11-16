package com.javarush.krylov.src.Service;

import java.util.*;

public class LanguageChecker {

    public String getLanguageByPattern(String text) {
        List<Pattern> languagePatterns = Arrays.asList(Pattern.values());

        return languagePatterns.stream()
                .filter(pattern -> isPatternWordInText(text, pattern))
                .map(Pattern::getLabel)
                .findFirst()
                .orElse("");
    }

    private boolean isPatternWordInText(String text, Pattern pattern) {
        String[] frequentWords = pattern.getDescription();

        return Arrays.stream(frequentWords)
                .filter(word -> getFrequentWordCount(text, word) > 1)
                .count() > 1;
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