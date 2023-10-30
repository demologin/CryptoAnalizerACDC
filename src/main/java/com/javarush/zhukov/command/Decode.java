package com.javarush.zhukov.command;

import com.javarush.zhukov.constant.AlphaBet;
import com.javarush.zhukov.inputOut.FilePathForDecode;
import com.javarush.zhukov.inputOut.KeyForCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class Decode {
    private static final Logger logger = Logger.getLogger(Decode.class.getName());

    public static void decodingCaesar() {
        Path pathReadFile = FilePathForDecode.getPathReadFile();
        Path pathWriteFile = FilePathForDecode.getPathWriteFile();
        int key = KeyForCode.getKey();
        try (BufferedReader reader = Files.newBufferedReader(pathReadFile);
             BufferedWriter writer = Files.newBufferedWriter(pathWriteFile)
        ) {
            decodingProcess(key, reader, writer);
            System.out.println("\nУспешно\n");
        } catch (IOException e) {
            logger.severe("Произошла ошибка " + e);
            System.out.println("попробуйте ещё раз");
        }
    }

    static void decodingProcess(int key, BufferedReader reader, BufferedWriter writer) throws IOException {
        while (reader.ready()) {
            char symbol = (char) reader.read();
            symbol = Character.toLowerCase(symbol);
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
