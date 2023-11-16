package com.javarush.khmelov.command;

import com.javarush.khmelov.constant.Alphabet;
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

    public static final int COUNT_TRY_FIND = 10;

    @Override
    public Result execute(String[] parameters) {
        String encryptedFilename = parameters[0];
        String dictionaryFilename = parameters[1];
        String analyzedFilename = parameters[2];

        List<Character> dictChar = getCharacterList(Alphabet.charsArray);
        List<Character> sourceChar = findBestVersionAlphabet(encryptedFilename, dictionaryFilename);

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

    private List<Character> findBestVersionAlphabet(String encryptedFilename, String dictionaryFilename) {
        double[][] matrix = Statistics.getBiGramStat(PathBuilder.get(encryptedFilename));
        double[][] original = Statistics.getBiGramStat(PathBuilder.get(dictionaryFilename));
        double bestDistance = Double.MAX_VALUE;
        char[] bestChars = null;
        System.out.println("\nAnalyze");
        for (int i = COUNT_TRY_FIND; i > 0; i--) {
            char[] chars = Alphabet.charsArray.clone();
            double probeDistance = Statistics.getCharsByRandomSwapper(chars, matrix, original);
            if (probeDistance < bestDistance) {
                i += COUNT_TRY_FIND;
                bestDistance = probeDistance;
                bestChars = chars.clone();
                //For debug only, here System.out.println - not the best solution. Here need the logger
                System.out.println("Best distance = " + bestDistance);
            }
        }
        return getCharacterList(bestChars);
    }

    private static List<Character> getCharacterList(char[] chars) {
        return String.valueOf(chars)
                .chars()
                .mapToObj(c -> (char) c)
                .toList();
    }


}
