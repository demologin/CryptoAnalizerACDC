package com.javarush.kotovych;

import com.javarush.kotovych.constants.Constants;
import com.javarush.kotovych.containers.Action;
import com.javarush.kotovych.containers.ActionContainer;
import com.javarush.kotovych.containers.AlphabetContainer;

import java.io.IOException;
import java.nio.file.Path;

public class JavaFXApplication {
    public static void main(String[] args) throws IOException{
        Path p1 = Path.of("/Users/roman/IdeaProjects/CryptoAnalizerACDC/text2.txt");
        Path p2 = Path.of("/Users/roman/IdeaProjects/CryptoAnalizerACDC/out.txt");
        Path p3 = Path.of("/Users/roman/IdeaProjects/CryptoAnalizerACDC/out2.txt");

        Action encoder = ActionContainer.get(Constants.ENCODE);
        Action decoder = ActionContainer.get(Constants.BRUTE_FORCE);

        encoder.execute(p1, 6, p2, AlphabetContainer.get(Constants.RU));
        decoder.execute(p2, 0, p3, AlphabetContainer.get(Constants.RU));
    }
}
