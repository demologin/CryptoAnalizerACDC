package com.javarush.berezovskiy.cryptoanalizer.command;

import com.javarush.berezovskiy.cryptoanalizer.constant.Alphabet;
import com.javarush.berezovskiy.cryptoanalizer.constant.Const;
import com.javarush.berezovskiy.cryptoanalizer.entity.Result;
import com.javarush.berezovskiy.cryptoanalizer.entity.ResultCode;
import com.javarush.berezovskiy.cryptoanalizer.exception.AppException;
import com.javarush.berezovskiy.cryptoanalizer.util.PathBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractAction implements Action{

    //common methods for actions: Encode Decode Bruteforce
    public Result copyWithKey(String sourceTextFile, String targetTextFile, int key) {
        Path source = PathBuilder.get(sourceTextFile);
        Path target = PathBuilder.get(targetTextFile);
        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(target)
        ) {
            int value;
            int length = Alphabet.CHARS.length;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);
                if (Alphabet.index.containsKey(character)) {
                    Integer index = Alphabet.index.get(character);
                    index = (index + key + Math.abs(key) * length) % length;
                    writer.write(Alphabet.CHARS[index]);
                } else if (character == '\n') {
                    writer.write(character);
                }
            }
        } catch (IOException e) {
            throw new AppException(Const.INCORRECT_FILE + e.getMessage(), e);
        }
        return new Result(ResultCode.OK, targetTextFile);
    }
}
