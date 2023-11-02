package com.javarush.levchuk.mods;

import com.javarush.levchuk.constant.Alphabet;
import com.javarush.levchuk.mods.tools.Coding;
import com.javarush.levchuk.mods.tools.PathMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.levchuk.constant.Alphabet.*;
import static com.javarush.levchuk.constant.UtilConstants.*;


public class BruteForce {
    public BruteForce() {
        System.out.println("Enter the path to the file or its name if it is in the default folder (Or Enter for encrypted.txt) :");
        Path source = PathMaker.makePath(DEFAULT_ENCRYPT_FILE_NAME);

        System.out.println("Enter the path or name for the output file (Or Enter for bruteDecrypted.txt ) :");
        Path target = PathMaker.makePath(DEFAULT_BRUTEFORCE_FILE_NAME);

        int key = searchKey(source);
        Coding.processingToFile(source, target, key);
    }

    public int searchKey(Path source) {
        int key = 0;
        int numberMatches = 0;
        for (int i = 0; i < getAlphabetSize(); i++) {
            Map<String, Integer> textSyllables = getTextToSyllables(source, i);
            int count = 0;
            for (String syllable : SYLLABLES_RUS) {
                if (textSyllables.containsKey(syllable)) {
                    count++;
                }
            }
            if (count > numberMatches) {
                numberMatches = count;
                key = i;
            }
        }
        return key;
    }

    public Map<String, Integer> getTextToSyllables(Path path, int key) {
        Map<String, Integer> textSyllables = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            char firstChar = ' ';
            char secondChar = ' ';
            int numberChar;
            while ((numberChar = reader.read()) > -1) {
                firstChar = Coding.charEncryptor((Character.toLowerCase((char) numberChar)), key);
                while ((numberChar = reader.read()) > -1) {
                    secondChar = Coding.charEncryptor((Character.toLowerCase((char) numberChar)), key);
                    if (alphabetMap.containsKey(firstChar) && alphabetMap.containsKey(secondChar)) {
                        String string = String.valueOf(firstChar) + String.valueOf(secondChar);
                        if (textSyllables.containsKey(string)) {
                            textSyllables.put(string, textSyllables.get(string) + 1);
                        } else {
                            textSyllables.put(string, 1);
                        }
                    }
                    break;
                }
            }
        } catch (IOException e) {
            new RuntimeException();
        }
        return textSyllables;
    }
}