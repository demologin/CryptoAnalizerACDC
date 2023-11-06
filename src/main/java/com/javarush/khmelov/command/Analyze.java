package com.javarush.khmelov.command;

import com.javarush.khmelov.constant.Alphabet;
import com.javarush.khmelov.entity.Result;
import com.javarush.khmelov.entity.ResultCode;
import com.javarush.khmelov.exception.AppException;
import com.javarush.khmelov.util.PathBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Analyze extends AbstractAction {
    @Override
    public Result execute(String[] parameters) {
        String encryptedFilename = parameters[0];
        String dictionaryFilename = parameters[1];
        String analyzedFilename = parameters[2];

        List<Character> dictChar = getSortedChars(dictionaryFilename);
        List<Character> sourceChar = getSortedChars(encryptedFilename);

        Path source = PathBuilder.get(encryptedFilename);
        Path target = PathBuilder.get(analyzedFilename);
        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(target)
        ) {
            int value;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                int index = sourceChar.indexOf(character);
                Character characterDecrypted = dictChar.get(index);
                writer.write(
                        characterDecrypted != null
                                ? characterDecrypted
                                : character);
            }
        } catch (IOException e) {
            throw new AppException(e.getMessage(), e);
        }
        return new Result(ResultCode.OK, analyzedFilename);
    }

    private List<Character> getSortedChars(String encryptedFile) {
        Map<Character, Integer> map = createStartMap();
        Path path = PathBuilder.get(encryptedFile);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int value;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);
                if (map.containsKey(character)) {
                    Integer i = map.get(character);
                    map.put(character, ++i);
                }
            }
        } catch (IOException e) {
            throw new AppException(e.getMessage(), e);
        }

        return map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .toList();
    }

    private Map<Character, Integer> createStartMap() {
        return Alphabet.index.keySet()
                .stream()
                .collect(Collectors.toMap(
                        character -> character,
                        character -> 0, (a, b) -> b,
                        LinkedHashMap::new
                ));
    }

}
