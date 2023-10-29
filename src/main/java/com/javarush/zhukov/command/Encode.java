package com.javarush.zhukov.command;

import com.javarush.zhukov.constant.AlphaBet;
import com.javarush.zhukov.inputOut.FilePathForEncode;
import com.javarush.zhukov.inputOut.KeyForCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encode {
    public static void encodingCesar(){
        Path pathReadFile = FilePathForEncode.getPathReadFile();
        Path pathWriteFile = FilePathForEncode.getPathWriteFile();
        int key = KeyForCode.getKey();

        try(BufferedReader reader = Files.newBufferedReader(pathReadFile);
            BufferedWriter writer = Files.newBufferedWriter(pathWriteFile)
        ) {
            encodingProcess(key, reader, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void encodingProcess(int key, BufferedReader reader, BufferedWriter writer) throws IOException {
        while (reader.ready()){
            char symbol = (char) reader.read();
            if (AlphaBet.alphaBet.containsKey(symbol)){
                int index = AlphaBet.alphaBet.get(symbol);
                writer.write(AlphaBet.arrayAlphaBet[(index+ key)%AlphaBet.arrayAlphaBet.length]);
            }else {
                writer.write(symbol);
            }
        }
    }
}
