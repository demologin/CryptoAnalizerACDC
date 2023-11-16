package com.javarush.boyarinov.commands;

import com.javarush.boyarinov.CreatePath;
import com.javarush.boyarinov.constats.Constant;
import com.javarush.boyarinov.exceptions.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;

public class BruteForce {

    private BruteForce() {

    }

    public static BruteForce getInstance() {
        return new BruteForce();
    }

    public void runBruteForce(String input, String output) {
        CreatePath path = new CreatePath();
        Decrypt decrypt = Decrypt.getInstance();

        int bestKey = -1;
        for (int key = 0; key < Constant.ALPHABET.length; key++) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(path.getPath(input))) {
                boolean conditional = findBestKey(bufferedReader, key);
                if (conditional) {
                    bestKey = key;
                }
            } catch (IOException e) {
                throw new AppException(e);
            }
        }
        decrypt.decode(input, output, bestKey);
    }

    private boolean findBestKey(BufferedReader bufferedReader, int key) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            char symbol = replaceCharacter(bufferedReader, key);
            stringBuilder.append(symbol);
            int index = stringBuilder.indexOf(Constant.PUNCTUATION_RULE);
            if (index > 0) {
                return true;
            }
            if (stringBuilder.length() > Constant.MAX_NUMBER_OF_SYMBOLS) {
                break;
            }
        }
        return false;
    }


    private char replaceCharacter(BufferedReader bufferedReader, int key) throws IOException {
        if (key == Constant.ALPHABET.length) {
            key++;
        }
        int read = bufferedReader.read();
        char symbol = Character.toLowerCase((char) read);
        for (int i = 0; i < Constant.ALPHABET.length; i++) {
            int index = (i - key) % Constant.ALPHABET.length;
            if (index < 0) {
                index += Constant.ALPHABET.length;
            }
            if (symbol == Constant.ALPHABET[i]) {
                return Constant.ALPHABET[index];
            }
        }
        return symbol;
    }
}

