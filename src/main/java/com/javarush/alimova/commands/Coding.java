package com.javarush.alimova.commands;

import com.javarush.alimova.dictionary.Alphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public abstract class Coding implements Command{



    @Override
    public void startCommand(String[] parameters) {
        //todo проверку на невалидность аргументов
        Path pathInput = Path.of(System.getProperty("user.dir"), "text", parameters[0]);
        Path pathOutput = Path.of(System.getProperty("user.dir"), "text", parameters[1]);
        try {
            Files.deleteIfExists(pathOutput);
            Files.createFile(pathOutput);
        } catch (IOException e) {
            //объявить, что не удалось создать файл
            throw new RuntimeException(e);
        }
        int keyCoding = Integer.parseInt(parameters[2]);
        System.out.println(pathInput + " " + pathOutput);
        codingText(pathInput, pathOutput, keyCoding);

    }

    @Override
    public String resultCommand() {
        return null;
    }

    protected void codingText(Path input, Path output, int key) {
        try (BufferedReader reader = Files.newBufferedReader(input);
             BufferedWriter writer = Files.newBufferedWriter(output, StandardOpenOption.WRITE)) {
            //CharBuffer buffer = CharBuffer.allocate(1024);
            int symbol;
            while((symbol = reader.read()) > -1) {
                char value = (char)Character.toLowerCase(symbol);
                if (!Alphabet.symbol.containsKey(value)) {
                    continue;
                }
                int index = Alphabet.symbol.get(value);
                int indexChars = getIndex(index, key);
                writer.write(Alphabet.CHARS[indexChars]);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            throw new RuntimeException(e);      //подумать, выкидывать ли выше, в общем, нужно
            //либо с самого начала обрабатывать всё выше
            //подумать, какие ещё могут быть исключения
        }

    }

    protected abstract int getIndex(int index, int key);
}
