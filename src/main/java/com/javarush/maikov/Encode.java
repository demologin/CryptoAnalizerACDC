package com.javarush.maikov;

import java.io.*;
import java.util.Arrays;


public class Encode {
    public Encode(String link, int key) {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(link)) {
            while (reader.ready()) {
                char target = (char) reader.read();
                boolean isCharAlphabet = false;
                boolean isCharCapital = false;
                for (char symbol : Constants.ALPHABET) {
                    if (target == symbol) {
                        isCharAlphabet = true;
                        break;
                    }
                }
                if (isCharAlphabet) {
                    int index = Arrays.binarySearch(Constants.ALPHABET, target);
                    if (index + key >= Constants.ALPHABET.length - 1) {
                        result.append(Constants.ALPHABET[(index + key) % Constants.ALPHABET.length]);
                    } else {
                        result.append(Constants.ALPHABET[index + key]);
                    }
                    continue;
                }
                for (char symbol : Constants.CAPITALLETTER) {
                    if (target == symbol) {
                        isCharCapital = true;
                        break;
                    }
                }
                if (isCharCapital) {
                    int index = Arrays.binarySearch(Constants.CAPITALLETTER, target);
                    if (index + key >= Constants.CAPITALLETTER.length - 1) {
                        result.append(Constants.CAPITALLETTER[(index + key) % Constants.CAPITALLETTER.length]);
                    } else {
                        result.append(Constants.CAPITALLETTER[index + key]);
                    } continue;
                }
                result.append(target);
            }
            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        }
    }

