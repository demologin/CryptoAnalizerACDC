package com.javarush.stukalov.services;

import com.javarush.stukalov.constant.RusAlphabet;
import com.javarush.stukalov.utils.CosineDistanceCalculator;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BruteForcer {
    private static BruteForcer instance;
    private static final Path referenceFile = Paths.get("text", "text.txt");
    private static final String referenceText = textFromFileToString(referenceFile);
    private final CosineDistanceCalculator cosineDistanceCalculator = CosineDistanceCalculator.getInstance();
    private final Decoder decoder = Decoder.getInstance();
    private List<Character> alphabet = RusAlphabet.getAlphabet();
    private BruteForcer() {

    }

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public static BruteForcer getInstance() {
        if (instance == null) {
            instance = new BruteForcer();
        }
        return instance;
    }

    public void bruteForce(Path encodedFile, Path decodedFile) {
        int totalKeys = alphabet.size();
        int bestKey = 0;
        double bestCosineDistance = 1;
        String encodedText = textFromFileToString(encodedFile);
        String decodedText;
        for (int key = 0; key < totalKeys; key++) {
            decodedText = decoder.decodeToText(encodedText, key);
            double cosineDistanceForKey = cosineDistanceCalculator.countCosDistance(decodedText, referenceText);
            if(bestCosineDistance > cosineDistanceForKey) {
                bestKey = key;
                bestCosineDistance = cosineDistanceForKey;
            }
        }
        decoder.decodeToFile(encodedFile, decodedFile, bestKey);
    }
    private static String textFromFileToString(Path filePath) {
        String text = null;
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            while (reader.ready()) {
                text = reader.readLine().toLowerCase();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return text;
    }

}
