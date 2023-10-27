package com.javarush.maikov;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Decode {
    public Decode(String linkIn, String linkOut, int key) {
        key = key > Constants.ALPHABET.length ? key % Constants.ALPHABET.length : key;
        try (FileReader reader = new FileReader(linkIn);
             FileWriter writer = new FileWriter(linkOut)) {
            while (reader.ready()) {
                int index;
                char target = (char) reader.read();
                if (target == 'ё') {    // я не смог пока справиться с ё при бинарном поиске, сбивается порядок
                    index = 6;
                    if (index - key < 0) {
                        int different = key - index;
                        writer.write(Constants.ALPHABET[(Constants.ALPHABET.length - different)]);
                    } else {
                        writer.write(Constants.ALPHABET[index - key]);
                    }
                    continue;
                }
                if (target == 'Ё') {    // я не смог пока справиться с ё при бинарном поиске, сбивается порядок
                    index = 6;
                    if (index - key < 0) {
                        int different = key - index;
                        writer.write(Constants.CAPITALLETTER[(Constants.CAPITALLETTER.length - different)]);
                    } else {
                        writer.write(Constants.CAPITALLETTER[index - key]);
                    }
                    continue;
                }
                boolean isCharAlphabet = Arrays.binarySearch(Constants.ALPHABET, target) >= 0;
                boolean isCharCapital = Arrays.binarySearch(Constants.CAPITALLETTER, target) >= 0;
                if (isCharAlphabet) {
                    index = Arrays.binarySearch(Constants.ALPHABET, target);
                    if (index - key < 0) {
                        int different = key - index;
                        writer.write(Constants.ALPHABET[(Constants.ALPHABET.length - different)]);
                    } else {
                        writer.write(Constants.ALPHABET[index - key]);
                    }
                    continue;
                }
                if (isCharCapital) {
                    index = Arrays.binarySearch(Constants.CAPITALLETTER, target);
                    if (index - key < 0) {
                        int different = key - index;
                        writer.write(Constants.CAPITALLETTER[(Constants.CAPITALLETTER.length - different)]);
                    } else {
                        writer.write(Constants.CAPITALLETTER[index - key]);
                    }
                    continue;
                }
                writer.write(target);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, укажите путь к действующему файлу");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}