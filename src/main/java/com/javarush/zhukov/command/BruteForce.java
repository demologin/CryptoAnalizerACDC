package com.javarush.zhukov.command;

import com.javarush.zhukov.constant.AlphaBet;
import com.javarush.zhukov.inputOut.FilePathForBruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class BruteForce {
    private static final Logger logger = Logger.getLogger(BruteForce.class.getName());
    private static final Path pathReadFile = FilePathForBruteForce.getPathReadFile();

    public static void decodeBruteForce() {
        Path pathWriteFile = FilePathForBruteForce.getPathWriteFile();
        try (BufferedReader reader = Files.newBufferedReader(pathReadFile);
             BufferedWriter writer = Files.newBufferedWriter(pathWriteFile)) {
            System.out.println("Ожидаем выполнения...");
            int key = selectionKey();
            Decode.decodingProcess(key, reader, writer);
            System.out.println("\nУспешно\n");
        } catch (IOException e) {
            logger.severe("Произошла ошибка " + e);
            System.out.println("попробуйте ещё раз");
        }
    }

    private static int selectionKey() throws IOException {
        int maxCountSpace = 0;
        int resultKey = 0;
        for (int key = 0; key < AlphaBet.arrayAlphaBet.length; key++) {
            try (BufferedReader readerLocal = Files.newBufferedReader(pathReadFile)
            ) {
                int countSpace = 0;
                countSpace = countingSpace(readerLocal, key, countSpace);
                if (countSpace > maxCountSpace) {
                    maxCountSpace = countSpace;
                    resultKey = key;
                }
            }
        }
        return resultKey;
    }

    private static int countingSpace(BufferedReader reader, int key, int countSpace) throws IOException {
        while (reader.ready()) {
            char symbol = (char) reader.read();
            if (AlphaBet.alphaBet.containsKey(symbol)) {
                int index = AlphaBet.alphaBet.get(symbol);
                if (index - key < 0) {
                    if (AlphaBet.arrayAlphaBet[AlphaBet.arrayAlphaBet.length + (index - key)] == ' ') {
                        countSpace++;
                    }
                } else {
                    if (AlphaBet.arrayAlphaBet[index - key] == ' ') {
                        countSpace++;
                    }
                }
            }
        }
        return countSpace;
    }
}
