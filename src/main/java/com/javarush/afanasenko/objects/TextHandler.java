package com.javarush.afanasenko.objects;


import com.javarush.afanasenko.exception.CryptoException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TextHandler {


    private List<String> symbolList;

    public TextHandler(Path path) {
        symbolList = textFromFile(path);
    }

    public void setsymbolList(List<String> symbolList) {
        this.symbolList = symbolList;
    }

    public List<String> getsymbolList() {
        return symbolList;
    }

    public static List<String> textFromFile(Path path) throws CryptoException {
        List<String> text = new ArrayList<>();
        if (Files.isRegularFile(path)) {
            try (BufferedReader buffer = Files.newBufferedReader(path)) {
                int i = 0;
                while (buffer.ready()) {
                    String c = new String(new char[]{(char)buffer.read()});
                    text.add(c);
                    i++;
                }
            } catch (IOException ex) {
                throw new CryptoException("Проблема при чтении файла");
            }
        }
        return text;
    }

    public void textToFile(String pathString) throws CryptoException {
        try {
            Path pathTo = Path.of(pathString);
            if (Files.exists(pathTo)) Files.delete(pathTo);
            Path path = Files.createFile(pathTo);

            try (BufferedWriter bf = Files.newBufferedWriter(path)) {
                for (int i = 0; i < symbolList.size(); i++) {
                    if (symbolList.get(i) != null) bf.write(symbolList.get(i));
                }
            }
            System.out.println("Cоздан новый файл, путь к нему:" + pathTo);
        } catch (IOException ex) {
            throw new CryptoException("Ошибка при создании нового файла");
        }
    }
}



