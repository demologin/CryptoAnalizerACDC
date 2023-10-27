package com.javarush.alimova.commands;

import com.javarush.alimova.dictionary.Alphabet;
import com.javarush.alimova.dictionary.Const;
import com.javarush.alimova.exception.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public abstract class Coding implements Command{


    @Override
    public Result startCommand(String[] parameters) {

        Path pathInput = Path.of(System.getProperty("user.dir"), "text", parameters[0]);
        Path pathOutput = Path.of(System.getProperty("user.dir"), "text", parameters[1]);

        codingText(parameters);
        return getResult(pathInput, pathOutput);
    }



    protected void codingText(String[] parameters) {

        Path input = Path.of(System.getProperty("user.dir"), "text", parameters[0]);
        Path output = Path.of(System.getProperty("user.dir"), "text", parameters[1]);

        try {
            Files.deleteIfExists(output);
            Files.createFile(output);
        } catch (IOException e) {
            throw new AppException(Const.ERROR_FILE + ": " + e.getMessage(), e);
        }

        int key = Integer.parseInt(parameters[2]);      //надо подумать, как сделать покрасивше (но может не выйти)
        try (BufferedReader reader = Files.newBufferedReader(input);
             BufferedWriter writer = Files.newBufferedWriter(output, StandardOpenOption.WRITE)) {
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

        }
        catch (IOException e) {
            throw new AppException(Const.ERROR_FILE + ": " + e.getMessage(), e);

        }

    }


    protected abstract int getIndex(int index, int key);

    protected abstract Result getResult(Path inputFile, Path outputFile);
}
