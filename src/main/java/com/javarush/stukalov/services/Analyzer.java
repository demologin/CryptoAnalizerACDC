package com.javarush.stukalov.services;

import com.javarush.stukalov.constant.RusAlphabet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Analyzer {
    private static Analyzer instance;
    private List<Character> alphabet = RusAlphabet.getAlphabet();
    private final Decoder DECODER = Decoder.getInstance();
    private Analyzer() {

    }

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public static Analyzer getInstance() {
        if (instance == null) {
            instance = new Analyzer();
        }
        return instance;
    }

    public void analyze(Path source, Path destination) {
        TreeMap<Integer, String> decodedStrings = new TreeMap<>();
        int keys = alphabet.size();
        try (BufferedReader reader = Files.newBufferedReader(source)) {
            var scanner = new Scanner(System.in);
            char[] sourceString = reader.readLine().toLowerCase().toCharArray();
            for (int key = 0; key < keys; key++) {
                StringBuilder bruteString = new StringBuilder();
                for (int character = 0; character < sourceString.length; character++) {
                    if(alphabet.contains(sourceString[character])) {
                        int oldIndex = alphabet.indexOf(sourceString[character]);
                        int newIndex = oldIndex + (alphabet.size() - (key % alphabet.size()));
                        bruteString.append(alphabet.get(newIndex % alphabet.size()));
                    } else {
                        bruteString.append(sourceString[character]);
                    }
                }
                decodedStrings.put(key, bruteString.toString());
            }
            for (var entry : decodedStrings.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("Select the appropriate key");
            int key = scanner.nextInt();
            DECODER.decodeToFile(source, destination, key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
