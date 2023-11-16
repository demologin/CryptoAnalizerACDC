package com.javarush.alimova.commands;

import com.javarush.alimova.controller.CommandContainer;
import com.javarush.alimova.dictionary.Alphabet;
import com.javarush.alimova.dictionary.Const;
import com.javarush.alimova.exception.AppException;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce extends Coding{

    private final String[] validSyntax = {", ", ". "};

    private final String[] errorSyntax = {"\n!", "\n,", "\n?", ",,", ",!", "\n.", ",?"};

    private int keyCoding = -1;

    @Override
    protected Result getResult(Path inputFile, Path outputFile) {
        return new Result(true, CommandContainer.BRUTEFORCE, inputFile, outputFile, keyCoding);
    }

    @Override
    protected int getIndex(int index, int key) {
        if (index - key < 0) {
            return Alphabet.SIZE + (index - key);
        }
        return index - key;
    }

    @Override
    protected void codingText(String[] parameters) {

        Path input = getPathToFile(parameters[0]);

        try (SeekableByteChannel scb = Files.newByteChannel(input)) {
            ByteBuffer buffer = ByteBuffer.allocate(2048);
            String encoding = System.getProperty("file.encoding");
            scb.read(buffer);//считываем кусок буфера, на который будем опираться
            buffer.flip();
            int validKey = -1;
            for (int i = 1; i < Alphabet.SIZE; i++) {
                buffer.position(0);
                String lineFile = decodeLine(Charset.forName(encoding).decode(buffer).toString(), i);
                if (checkKeyValidity(lineFile)) {
                    validKey = i;
                    break;
                }
            }
            if (validKey != -1) {
                keyCoding = validKey;
                super.codingText(new String[]{parameters[0], parameters[1], String.valueOf(validKey)});
            }

        } catch (IOException e) {
            throw new AppException(Const.ERROR_FILE + ": " + e.getMessage(), e);
        }

    }

    protected String decodeLine(String charsetFile, int key) {
        StringBuilder lineFile = new StringBuilder();
        for (char symbol :
                charsetFile.toCharArray()) {
            char value = Character.toLowerCase(symbol);
            if (!Alphabet.symbol.containsKey(value)) {
                continue;
            }
            int index = Alphabet.symbol.get(value);
            int indexChars = getIndex(index, key);
            lineFile.append(Alphabet.CHARS[indexChars]);
        }
        return lineFile.toString();
    }

    protected boolean checkKeyValidity(String lineFile) {
        for (String example :
                errorSyntax) {
            if (lineFile.contains(example)) return false;
        }
        for (String example :
                validSyntax) {
            if (!lineFile.contains(example)) return false;
        }
        return true;
    }
}
