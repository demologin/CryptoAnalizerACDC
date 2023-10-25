package com.javarush.kotovych;

import com.javarush.kotovych.commands.Action;
import com.javarush.kotovych.commands.Actions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JavaFXApplication {
    public static void main(String[] args) {
        System.out.println();
        Action encoder = Actions.get("DECODE");
        try(BufferedReader reader = Files.newBufferedReader(Path.of("/Users/roman/IdeaProjects/CryptoAnalizerACDC/out.txt"));
            BufferedWriter writer = Files.newBufferedWriter(Path.of("/Users/roman/IdeaProjects/CryptoAnalizerACDC/out2.txt"))){
            encoder.execute(reader, 5, writer);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
