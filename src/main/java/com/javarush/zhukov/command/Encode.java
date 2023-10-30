package com.javarush.zhukov.command;

import com.javarush.zhukov.constant.AlphaBet;
import com.javarush.zhukov.inputOut.FilePathForEncode;
import com.javarush.zhukov.inputOut.KeyForCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class Encode {
    private static final Logger logger = Logger.getLogger(Encode.class.getName());

    public static void encodingCaesar() {
        Path pathReadFile = FilePathForEncode.getPathReadFile();
        Path pathWriteFile = FilePathForEncode.getPathWriteFile();
        int key = KeyForCode.getKey();
        try (BufferedReader reader = Files.newBufferedReader(pathReadFile);
             BufferedWriter writer = Files.newBufferedWriter(pathWriteFile)
        ) {
            encodingProcess(key, reader, writer);
            System.out.println("\nУспешно\n");
        } catch (IOException e) {
            logger.severe("Произошла ошибка " + e);
            System.out.println("попробуйте ещё раз");
        }
    }

    static void encodingProcess(int key, BufferedReader reader, BufferedWriter writer) throws IOException {
        while (reader.ready()) {
            char symbol = (char) reader.read();
            symbol = Character.toLowerCase(symbol);
            if (AlphaBet.alphaBet.containsKey(symbol)) {
                int index = AlphaBet.alphaBet.get(symbol);
                writer.write(AlphaBet.arrayAlphaBet[(index + key) % AlphaBet.arrayAlphaBet.length]);
            } else {
                writer.write(symbol);
            }
        }
    }
}
