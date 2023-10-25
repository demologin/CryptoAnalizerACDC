package com.javarush.maikov;

import java.io.*;
import java.util.Arrays;


public class Encode {
    public Encode(String link, int key) {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(link)) {
            while (reader.ready()) {
                char target = (char) reader.read();
                for (char symbol : Constants.ALPHABET) {
                    if (Character.toString(target).equals(Character.toString(symbol))) {
                        int index = Arrays.binarySearch(Constants.ALPHABET, target);
                        if (index + key > Constants.ALPHABET.length) { // check if index + key>Array.length
                            index = index % Constants.ALPHABET.length;
                        }
                        result.append(Constants.ALPHABET[index + key]); // add to result
                        break;
                    }
                }
                for (char symbol2 : Constants.CAPITALLETTER) {
                    if (Character.toString(target).equals(Character.toString(symbol2))) {
                        int index = Arrays.binarySearch(Constants.CAPITALLETTER, target);
                        if (index + key > Constants.CAPITALLETTER.length) { // check if index + key>Array.length
                            index = index % Constants.CAPITALLETTER.length;
                        }
                        result.append(Constants.CAPITALLETTER[index + key]); // add to result
                        break;

                    }

                }
                result.append(target);
            }
            System.out.println(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

