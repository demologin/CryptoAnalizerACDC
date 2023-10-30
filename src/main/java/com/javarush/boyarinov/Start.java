package com.javarush.boyarinov;


import com.javarush.boyarinov.constats.Constant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Start {
    public static void main(String[] args) {

        CreatePath path = new CreatePath();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path.getPath("text.txt"));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(path.getPath("encryptText.txt"))) {
            while (bufferedReader.ready()) {
                int read = bufferedReader.read();
                int setKey = 53;
                int key = setKey % Constant.ALPHABET.length;
                char symbol = Character.toLowerCase((char) read);
                for (int i = 0; i < Constant.ALPHABET.length; i++) {
                        if (symbol == Constant.ALPHABET[i]) {
                            if ((i + key) > Constant.ALPHABET.length - 1) {
                                int i2 = (i + key) - Constant.ALPHABET.length;
                                symbol = Constant.ALPHABET[i2];
                                break;
                            } else {
                                symbol = Constant.ALPHABET[i + key];
                                break;
                            }
                        }
                }
                bufferedWriter.write(symbol);
            }

        } catch (Exception e) {
            throw new AppException(e);
        }

    }
}
