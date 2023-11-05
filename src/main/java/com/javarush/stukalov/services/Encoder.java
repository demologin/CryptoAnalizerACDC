package com.javarush.stukalov.services;

import com.javarush.stukalov.constant.RusAlphabet;
import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Encoder {
    private static Encoder instance;
    private List<Character> alphabet = RusAlphabet.getAlphabet();
    private Encoder() {
    }
    public static Encoder getInstance() {
        if (instance == null) {
            instance = new Encoder();
        }
        return instance;
    }

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public void encode(Path source, Path destination, int key)  {
        try(BufferedReader sourceFile = new BufferedReader(new FileReader(source.toFile()));
        BufferedWriter destinationFile = new BufferedWriter(new FileWriter(destination.toFile()))) {
            while (sourceFile.ready()) {
                char sourceChar = Character.toLowerCase((char)sourceFile.read());
                int oldIndex = alphabet.indexOf(sourceChar);
                int newIndex = (oldIndex + key) % alphabet.size();
                destinationFile.write(alphabet.get(newIndex));
            }
            System.out.println("Encoding has been completed");

        } catch (Throwable e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Cannot read the source file");
            } else if (e instanceof IndexOutOfBoundsException) {
                System.out.println("There is no such a character in the Alphabet");
            } else if (e instanceof IOException){
                System.out.println("Cannot write the source file");
            } else if (e instanceof NullPointerException) {
                System.out.println("The was a null somewhere");
                e.printStackTrace();
            }
        }

    }
}
