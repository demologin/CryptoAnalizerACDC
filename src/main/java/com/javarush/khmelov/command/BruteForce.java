package com.javarush.khmelov.command;

import com.javarush.khmelov.constant.Alphabet;
import com.javarush.khmelov.entity.Result;
import com.javarush.khmelov.util.PathBuilder;
import com.javarush.khmelov.util.Statistics;

public class BruteForce extends AbstractAction {

    @Override
    public Result execute(String[] parameters) {
        String encryptedFilename = parameters[0];
        String decryptedFilename = parameters[1];
        int bestKey = 0;
        double bestDestination = Double.MAX_VALUE;
        double[][] standardStat = Statistics.getBiGramStat(PathBuilder.get("dict.txt"));
        double[][] encryptedStat = Statistics.getBiGramStat(PathBuilder.get(encryptedFilename));
        for (int key = Alphabet.charsArray.length; key >= 0; key--) {
            double destination = Statistics.calcDistance(encryptedStat, standardStat);
            if (destination < bestDestination) {
                bestDestination = destination;
                bestKey = key;
            }
            Statistics.rotate(encryptedStat);
        }
        return copyWithKey(encryptedFilename, decryptedFilename, bestKey);
    }

}
