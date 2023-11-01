package com.javarush.levchuk.mods;

import com.javarush.levchuk.mods.tools.Coding;
import com.javarush.levchuk.mods.tools.PathMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.levchuk.constant.Alphabet.alphabetMap;
import static com.javarush.levchuk.constant.Alphabet.getAlphabetSize;
import static com.javarush.levchuk.constant.UtilConstants.*;


public class BruteForce {
    public BruteForce() {
        System.out.println("Enter the path to the file or its name if it is " +
                "in the default folder (Or Enter for encrypted.txt) :");
        String defaultSourceName = "encrypted.txt";
        Path source = PathMaker.makePath(defaultSourceName);
        System.out.println("Enter the path or name for the output file (Or Enter for bruteDecrypted.txt ) :");
        String defaultTargetName = "bruteDecrypted.txt";
        Path target = PathMaker.makePath(defaultTargetName);
/*        char findChar =' ';
        int key = searchForKeyBySpace(source, findChar);
        System.out.printf("Found key: %d", key);
        Coding.processingToFile(source,target, 1*key);*/
        int key = searchKey(source);
        Coding.processingToFile(source, target, key);
    }

    public int searchKey(Path source) {
        int key = 0;
        int numberMatches = 0;
        Map<String, Integer> dictionary = textToSyllables(Path.of(DICTIONARY_TEXT_SOURCE), 0);
        System.out.println(dictionary);
        for (int i = 0; i < getAlphabetSize(); i++) {
            Map<String, Integer> textSyllables = textToSyllables(source, i);
            int count = 0;
            for (Map.Entry<String, Integer> entry  : dictionary.entrySet()) {
                if(textSyllables.containsKey(entry.getKey())){
                    count++;
                }
            }
            if (count > numberMatches) {
                numberMatches = count;
                key = i;
                System.out.println(count);
                System.out.println(i);
            }
        }
        System.out.println(key);
        return key;
    }

    public Map<String, Integer> textToSyllables(Path path, int key) {
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

/*    public int searchForKeyBySpace(Path source, char spaceChar) {
        int maxNumberRepeat = 0;
        int probableKey=0;
        for (int key = 0; key < Alphabet.getAlphabetSize(); key++) {
            int numberRepeating = CharacterCounter.numberRepetitionsChar(source, spaceChar, key);
            if (maxNumberRepeat < numberRepeating) {
                maxNumberRepeat = numberRepeating;
                probableKey=key;
            }
        }
        return probableKey;
    }*/

}
