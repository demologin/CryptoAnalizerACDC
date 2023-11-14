package com.javarush.khmelov.util;

import com.javarush.khmelov.constant.Alphabet;
import com.javarush.khmelov.exception.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>The phrase "мама#мыла#раму#" has the alphabet like this: "маылру#"
 * <p>The command counts combinations of pairs in the format
 * <table border="1">
 * <tr><td>     </td><td><b>м</td><td><b>а</td><td><b>ы</td><td><b>л</td><td><b>р</td><td><b>у</td><td><b>#</td></tr>
 * <tr><td><b>м</b></td><td>0</td><td>2</td><td>1</td><td>0</td><td>0</td><td>1</td><td>0</td></tr>
 * <tr><td><b>а</b></td><td>2</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>2</td></tr>
 * <tr><td><b>ы</b></td><td>0</td><td>0</td><td>0</td><td>1</td><td>0</td><td>0</td><td>0</td></tr>
 * <tr><td><b>л</b></td><td>0</td><td>1</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td></tr>
 * <tr><td><b>р</b></td><td>0</td><td>1</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td></tr>
 * <tr><td><b>у</b></td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td></tr>
 * <tr><td><b>#</b></td><td>1</td><td>0</td><td>0</td><td>0</td><td>1</td><td>0</td><td>0</td></tr>
 * </table>
 *
 * <p>The command calculates such statistics of pairs,
 * normalizes them by the length of the text and create biGram matrix
 */
public class Statistics {

    private Statistics() {
    }

    /**
     * Reads a chars of data from path
     * and return biGram statistics calculates based on standard alphabet.
     *
     * @param path - source txt file
     * @return double[][] biGram
     * @throws com.javarush.khmelov.exception.AppException common exception this project
     */
    public static double[][] getBiGramStat(Path path) {
        int length = Alphabet.charsArray.length;
        double[][] biGramStat = new double[length][length];
        char prefix = '\u0000';
        int value;
        long pairCount = 0;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (-1 != (value = reader.read())) {
                char current = (char) value;
                Integer indexPrefix = Alphabet.index.get(prefix);
                Integer indexCurrent = Alphabet.index.get(current);
                if (indexPrefix != null && indexCurrent != null) {
                    biGramStat[indexPrefix][indexCurrent]++;
                    pairCount++;
                }
                prefix = current;
            }
        } catch (IOException e) {
            throw new AppException(e);
        }
        for (int i = 0; i < biGramStat.length; i++) {
            for (int j = 0; j < biGramStat[i].length; j++) {
                biGramStat[i][j] /= pairCount;
            }
        }
        return biGramStat;
    }

    /**
     * Method calc |firstMatrix-secondMatrix|
     *
     * @param firstMatrix  - one biGram
     * @param secondMatrix - second biGram
     * @return |firstMatrix-secondMatrix|
     * @see com.javarush.khmelov.util.Statistics (what is the biGram)
     */
    public static double calcDistance(double[][] firstMatrix, double[][] secondMatrix) {
        double destination = 0;
        if (firstMatrix.length == secondMatrix.length
            && firstMatrix.length != 0
            && firstMatrix[0].length == secondMatrix[0].length
            && firstMatrix[0].length != 0
        ) {
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[i].length; j++) {
                    double delta = firstMatrix[i][j] - secondMatrix[i][j];
                    destination += delta * delta;
                }
            }
        } else {
            throw new AppException("incorrect matrix size");
        }
        return Math.sqrt(destination);
    }

    /**
     * Simple genetic algorithm
     *
     * @param genom    - biGram text
     * @param original - biGram dictionary
     * @return best alphabet as array
     * @see com.javarush.khmelov.util.Statistics (what is the biGram)
     */
    public static double getCharsByRandomSwapper(char[] chars, double[][] genom, double[][] original) {
        int skipSwapCounter = 0;
        double bestProbeDistance = Double.MAX_VALUE;
        genom = genom.clone();
        for (int i = 0; i < genom.length; i++) {
            genom[i] = genom[i].clone();
        }
        while (skipSwapCounter < genom.length * genom.length) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int i = random.nextInt(genom.length);
            int j = random.nextInt(genom.length);
            if (i != j) {
                swap(genom, i, j);
                double distance = calcDistance(genom, original);
                if (distance < bestProbeDistance) {
                    bestProbeDistance = distance;
                    skipSwapCounter = 0;
                    char ch = chars[j];
                    chars[j] = chars[i];
                    chars[i] = ch;
                } else {
                    swap(genom, j, i); //revert
                    skipSwapCounter++;
                }
            }
        }
        return bestProbeDistance;
    }


    /**
     * Modify biGram like this: маылру# -> аылру#м
     *
     * @param matrix biGram
     * @see com.javarush.khmelov.util.Statistics (what is the biGram)
     */
    public static void rotate(double[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            swap(matrix, i, i + 1);
        }
    }

    /**
     * Modify biGram swap(matrix,0,2) like this:  <b>м</b>а<b>ы</b>лру# -> <b>ы</b>а<b>м</b>лру#
     *
     * @param matrix biGram
     * @see com.javarush.khmelov.util.Statistics (what is the biGram)
     */
    public static void swap(double[][] matrix, int i, int j) {
        //swap rows
        double[] row = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = row;
        //swap cols
        for (int k = 0; k < matrix[i].length; k++) {
            double value = matrix[k][i];
            matrix[k][i] = matrix[k][j];
            matrix[k][j] = value;
        }
    }


}
