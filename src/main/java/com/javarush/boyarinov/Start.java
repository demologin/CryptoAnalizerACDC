package com.javarush.boyarinov;


import com.javarush.boyarinov.constats.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Start {
    public static void main(String[] args) {

        CreatePath path = new CreatePath();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path.getPath("mytext"))) {
            while (bufferedReader.ready()) {
                int read = bufferedReader.read();
                int setKey = 3;
                int key = setKey % Constant.ALPHABET.length;
                char symbol = (char) read;
                for (int i = 0; i < Constant.ALPHABET.length; i++) {
                    if (symbol == Constant.ALPHABET[i]) {
                        symbol = Constant.ALPHABET[i + key];
                    }
                }
            }

        } catch (IOException e) {
            throw new AppException(e);
        }

    }
}
