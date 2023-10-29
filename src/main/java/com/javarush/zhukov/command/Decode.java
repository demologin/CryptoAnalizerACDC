package com.javarush.zhukov.command;

import com.javarush.zhukov.constant.AlphaBet;
import com.javarush.zhukov.inputOut.FilePathForDecode;
import com.javarush.zhukov.inputOut.KeyForCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decode {
    public static void decodingCesar() {
        Path pathReadFile = FilePathForDecode.getPathReadFile();
        Path pathWriteFile = FilePathForDecode.getPathWriteFile();
        int key = KeyForCode.getKey();

        try (BufferedReader reader = Files.newBufferedReader(pathReadFile);
             BufferedWriter writer = Files.newBufferedWriter(pathWriteFile)
        ) {
            FilePathForDecode.getPathReadFile();
            decodingProcess(key, reader, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void decodingProcess(int key, BufferedReader reader, BufferedWriter writer) throws IOException {
        while (reader.ready()) {
            char symbol = (char) reader.read();
            if (AlphaBet.alphaBet.containsKey(symbol)) {
                int index = AlphaBet.alphaBet.get(symbol);
                if (index - key < 0) {
                    writer.write(AlphaBet.arrayAlphaBet[AlphaBet.arrayAlphaBet.length + (index - key)]);
                } else {
                    writer.write(AlphaBet.arrayAlphaBet[index - key]);
                }
            } else {
                writer.write(symbol);
            }

        }
    }
}
