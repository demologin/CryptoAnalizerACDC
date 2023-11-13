package com.javarush.stukalov.utils;

import java.util.HashMap;

public class CosineDistanceCalculator {
    private static CosineDistanceCalculator instance;
    private final BigramAnalysis bigramAnalysis = BigramAnalysis.getInstance();

    private CosineDistanceCalculator() {

    }

    public static CosineDistanceCalculator getInstance() {
        if (instance == null) {
            instance = new CosineDistanceCalculator();
        }
        return instance;
    }

    public Double countCosDistance(String encodedText, String referenceText) {
        HashMap<String, Double> normalizedEncodedTextBigrams = bigramAnalysis.analyzeBigramFreq(encodedText);
        HashMap<String, Double> normalizedReferenceTextBigrams = bigramAnalysis.analyzeBigramFreq(referenceText);
        double refVectorNorm = 0d;
        double encodedVectorNorm = 0d;
        double vectorsScalar = 0d;
        for (var key : normalizedEncodedTextBigrams.keySet()) {
            double valueA = normalizedEncodedTextBigrams.get(key);
            double valueB = normalizedReferenceTextBigrams.getOrDefault(key, 0d);

            encodedVectorNorm += valueA * valueA;
            refVectorNorm += valueB * valueB;
            vectorsScalar += valueA * valueB;
        }
        return 1 - vectorsScalar / (Math.sqrt(refVectorNorm) * Math.sqrt(encodedVectorNorm));
    }
}
