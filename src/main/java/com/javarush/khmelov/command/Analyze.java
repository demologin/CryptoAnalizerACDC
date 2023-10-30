package com.javarush.khmelov.command;

import com.javarush.khmelov.entity.Result;
import com.javarush.khmelov.entity.ResultCode;
import com.javarush.khmelov.exception.AppException;
import com.javarush.khmelov.util.PathBuilder;
import com.javarush.khmelov.util.Statistics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

    private List<Character> getSortedChars(String filename) {
        double[][] biGramStat = Statistics.getBiGramStat(PathBuilder.get(filename));
        char[] sortedChars = Statistics.getSortedChars(biGramStat);
        return String.valueOf(sortedChars)
                .chars()
                .mapToObj(c -> (char) c)
                .toList();
    }


}
