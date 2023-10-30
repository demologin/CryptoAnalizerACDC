package com.javarush.maikov;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;


public class Encode {
    public Encode(String linkIn, String linkOut, int key) {
        try (FileReader reader = new FileReader(linkIn);
             FileWriter writer = new FileWriter(String.valueOf(PathBuilder.getPath(linkOut)))) {
            while (reader.ready()) {
                int index;
                char target = (char) reader.read();
                if (target == 'ё') {    // я не смог пока справиться с ё при бинарном поиске, сбивается порядок
                    index = 6;
                    if (index + key >= Constants.ALPHABET.length - 1) {
                        writer.write(Constants.ALPHABET[(index + key) % Constants.ALPHABET.length]);
                    } else {
                        writer.write(Constants.ALPHABET[index + key]);
                    }
                    continue;
                }
                if (target == 'Ё') {    // я не смог пока справиться с ё при бинарном поиске, сбивается порядок
                    index = 6;
                    if (index + key >= Constants.CAPITALLETTER.length - 1) {
                        writer.write(Constants.CAPITALLETTER[(index + key) % Constants.ALPHABET.length]);
                    } else {
                        writer.write(Constants.CAPITALLETTER[index + key]);
                    }
                    continue;
                }
                boolean isCharAlphabet = Arrays.binarySearch(Constants.ALPHABET, target) >= 0;
                boolean isCharCapital = Arrays.binarySearch(Constants.CAPITALLETTER, target) >= 0;
                if (isCharAlphabet) {
                    index = Arrays.binarySearch(Constants.ALPHABET, target);
                    if (index + key >= Constants.ALPHABET.length - 1) {
                        writer.write(Constants.ALPHABET[(index + key) % Constants.ALPHABET.length]);
                    } else {
                        writer.write(Constants.ALPHABET[index + key]);
                    }
                    continue;
                }
                if (isCharCapital) {
                    index = Arrays.binarySearch(Constants.CAPITALLETTER, target);
                    if (index + key >= Constants.CAPITALLETTER.length - 1) {
                        writer.write(Constants.CAPITALLETTER[(index + key) % Constants.CAPITALLETTER.length]);
                    } else {
                        writer.write(Constants.CAPITALLETTER[index + key]);
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

