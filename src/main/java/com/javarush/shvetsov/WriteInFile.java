package com.javarush.shvetsov;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.shvetsov.isCorrectKeyClass.keyNumber;

public class WriteInFile {
    public static void writeInFile() {
        if (Runner.modeNumber == 1) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(isCorrectPathClass.pathOne));
                 BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(isCorrectPathClass.pathTwo))) {
                while (bufferedReader.ready()) {
                    char charY;
                    char charX = (char) bufferedReader.read();
                    charX = Character.toLowerCase(charX);
                    int index = 0;
                    for (int i = 0; i < Alphabet.ALPHABET.length; i++) {
                        if (charX == Alphabet.ALPHABET[i]) {
                            index = i;
                        }
                    }
                    if (charX == '\n') {
                        charY = '\n';
                    } else {
                        charY = Alphabet.ALPHABET[(index + keyNumber) % Alphabet.ALPHABET.length];

                    }
                    bufferedWriter.write(charY);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(isCorrectPathClass.pathTwo));
                 BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(isCorrectPathClass.pathThree))) {

                while (bufferedReader.ready()) {
                    char charY;
                    char charX = (char) bufferedReader.read();
                    charX = Character.toLowerCase(charX);
                    int index = 0;
                    for (int i = 0; i < Alphabet.ALPHABET.length; i++) {
                        if (charX == Alphabet.ALPHABET[i]) {
                            index = i;
                        }
                    }
                    if (charX == '\n') {
                        charY = '\n';
                    } else {
                        charY = Alphabet.ALPHABET[(Alphabet.ALPHABET.length + ((index - keyNumber) % Alphabet.ALPHABET.length)) % Alphabet.ALPHABET.length];

                    }
                    bufferedWriter.write(charY);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
