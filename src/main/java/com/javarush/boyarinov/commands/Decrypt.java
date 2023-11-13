package com.javarush.boyarinov.commands;

import com.javarush.boyarinov.exceptions.AppException;
import com.javarush.boyarinov.CreatePath;
import com.javarush.boyarinov.constats.Constant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Decrypt {

    private Decrypt() {

    }

    public static Decrypt getInstance() {
        return new Decrypt();
    }

    public void decode(String input, String output, int key) {
        CreatePath path = new CreatePath();

        try (BufferedReader bufferedReader = Files.newBufferedReader(path.getPath(input));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(path.getPath(output))) {

            while (bufferedReader.ready()) {
                char symbol = replaceCharacter(bufferedReader, key);
                bufferedWriter.write(symbol);
            }

        } catch (IOException e) {
            throw new AppException(e);
        }
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
