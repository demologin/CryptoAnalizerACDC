package com.javarush.stukalov.utils;

import java.util.HashMap;

public class BigramAnalysis {
    private static BigramAnalysis instance;

    private BigramAnalysis() {

    }

    public static BigramAnalysis getInstance() {
        if (instance == null) {
            instance = new BigramAnalysis();
        }
        return instance;
    }


    protected HashMap<String, Double> analyzeBigramFreq(String text) {
        var tempMap = new HashMap<String, Double>();
        for (int i = 0; i < text.length() - 1; i++) {
            String bigram = text.substring(i, i + 2);
            tempMap.put(bigram, tempMap.getOrDefault(bigram, 0.) + 1);
        }
        normalizeFreq(tempMap);
        return tempMap;
    }
        private void normalizeFreq (HashMap < String, Double > bigrams){
            double totalBigrams = bigrams.values().stream().mapToDouble(Double::doubleValue).sum();
            for (var entry : bigrams.entrySet()) {
                bigrams.put(entry.getKey(), entry.getValue() / totalBigrams);
            }
        }
    }
