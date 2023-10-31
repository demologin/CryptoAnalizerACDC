package com.javarush.maikov.bruteforce;

import com.javarush.maikov.constatns.Constants;
import com.javarush.maikov.util.PathBuilder;
import org.apache.commons.math3.analysis.function.Constant;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BruteForce {

    public BruteForce(String linkIn, String linkOut) {
        for (int i = 1; i < Constants.ALPHABET.length + 1; i++) {
            int key = i;
            try (FileWriter separator = new FileWriter(String.valueOf(PathBuilder.getPath(linkOut)))) {
                separator.append('\n');
                separator.append('\n');
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден, укажите путь к действующему файлу");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (FileReader reader = new FileReader(String.valueOf(PathBuilder.getPath(linkIn)));
                 FileWriter writer = new FileWriter(String.valueOf(PathBuilder.getPath(linkOut)))) {
                while (reader.ready()) {
                    int index;
                    char target = (char) reader.read();
                    if (target == 'ё') {    // я не смог пока справиться с ё при бинарном поиске, сбивается порядок
                        index = 6;
                        if (index - key < 0) {
                            int different = key - index;
                            writer.append(Constants.ALPHABET[(Constants.ALPHABET.length - different)]);
                        } else {
                            writer.append(Constants.ALPHABET[index - key]);
                        }
                        continue;
                    }
                    if (target == 'Ё') {    // я не смог пока справиться с ё при бинарном поиске, сбивается порядок
                        index = 6;
                        if (index - key < 0) {
                            int different = key - index;
                            writer.append(Constants.CAPITALLETTER[(Constants.CAPITALLETTER.length - different)]);
                        } else {
                            writer.append(Constants.CAPITALLETTER[index - key]);
                        }
                        continue;
                    }
                    boolean isCharAlphabet = Arrays.binarySearch(Constants.ALPHABET, target) >= 0;
                    boolean isCharCapital = Arrays.binarySearch(Constants.CAPITALLETTER, target) >= 0;
                    if (isCharAlphabet) {
                        index = Arrays.binarySearch(Constants.ALPHABET, target);
                        if (index - key < 0) {
                            int different = key - index;
                            writer.append(Constants.ALPHABET[(Constants.ALPHABET.length - different)]);
                        } else {
                            writer.append(Constants.ALPHABET[index - key]);
                        }
                        continue;
                    }
                    if (isCharCapital) {
                        index = Arrays.binarySearch(Constants.CAPITALLETTER, target);
                        if (index - key < 0) {
                            int different = key - index;
                            writer.append(Constants.CAPITALLETTER[(Constants.CAPITALLETTER.length - different)]);
                        } else {
                            writer.append(Constants.CAPITALLETTER[index - key]);
                        }
                        continue;
                    }
                    writer.append(target);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден, укажите путь к действующему файлу");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }