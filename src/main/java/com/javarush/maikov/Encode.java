package com.javarush.maikov;
import java.io.*;
import java.util.Arrays;


public class Encode {
    public Encode(String link, int key) {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(link)) {
            while (reader.ready()) {
                int index;
                char target = (char) reader.read();
                if (target == 'ё'){    // я не смог пока справиться с ё при бинарном поиске, сбивается порядок
                    index = 6;
                    if (index + key >= Constants.ALPHABET.length - 1) {
                        result.append(Constants.ALPHABET[(index + key) % Constants.ALPHABET.length]);
                    } else {
                        result.append(Constants.ALPHABET[index + key]);
                    }
                    continue;
                }
                if (target == 'Ё'){    // я не смог пока справиться с ё при бинарном поиске, сбивается порядок
                    index = 6;
                    if (index + key >= Constants.CAPITALLETTER.length - 1) {
                        result.append(Constants.CAPITALLETTER[(index + key) % Constants.ALPHABET.length]);
                    } else {
                        result.append(Constants.CAPITALLETTER[index + key]);
                    }
                    continue;
                }
                boolean isCharAlphabet = Arrays.binarySearch(Constants.ALPHABET, target) >= 0;
                boolean isCharCapital = Arrays.binarySearch(Constants.CAPITALLETTER, target) >= 0;
                if (isCharAlphabet) {
                    index = Arrays.binarySearch(Constants.ALPHABET, target);
                    if (index + key >= Constants.ALPHABET.length - 1) {
                        result.append(Constants.ALPHABET[(index + key) % Constants.ALPHABET.length]);
                    } else {
                        result.append(Constants.ALPHABET[index + key]);
                    }
                    continue;
                }
                if (isCharCapital) {
                    index = Arrays.binarySearch(Constants.CAPITALLETTER, target);
                    if (index + key >= Constants.CAPITALLETTER.length - 1) {
                        result.append(Constants.CAPITALLETTER[(index + key) % Constants.CAPITALLETTER.length]);
                    } else {
                        result.append(Constants.CAPITALLETTER[index + key]);
                    }
                    continue;
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

