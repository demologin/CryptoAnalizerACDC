package com.javarush.afanasenko;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;


public class TextHandler {


    private HashMap<Integer, Character> symbolMap;

    public TextHandler(Path path) {
        symbolMap = textFromFile(path);
    }

    public void setSymbolMap(HashMap<Integer, Character> symbolMap) {
        this.symbolMap = symbolMap;
    }

    public HashMap<Integer, Character> getSymbolMap() {
        return symbolMap;
    }

    public static HashMap<Integer, Character> textFromFile(Path path) throws CryptoException {
        HashMap<Integer, Character> text = new HashMap<>();
        if (Files.isRegularFile(path)) {
            try (BufferedReader buffer = Files.newBufferedReader(path)) {
                int i = 0;
                while (buffer.ready()) {
                    Character c = (char) buffer.read();
                    text.put(i, c);
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

            try (BufferedWriter output = Files.newBufferedWriter(path)) {
                for (int i = 0; i < symbolMap.size(); i++) {
                    if (symbolMap.get(i) != null) output.write(symbolMap.get(i));
                }
            }
        } catch (IOException ex) {
            throw new CryptoException("Ошибка при создании нового файла");
        }
    }
}



