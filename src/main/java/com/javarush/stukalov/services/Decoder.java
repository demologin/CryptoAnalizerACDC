package com.javarush.stukalov.services;

import com.javarush.stukalov.constant.RusAlphabet;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Decoder {
    private static Decoder instance;
    private List<Character> alphabet = RusAlphabet.getAlphabet();
    private Decoder() {

    }

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public static Decoder getInstance() {
        if (instance == null) {
            instance = new Decoder();
        }
        return instance;
    }

    public void decodeToFile(Path source, Path destination, int key) {
        try(BufferedReader sourceFile = Files.newBufferedReader(source);
            BufferedWriter destinationFile = Files.newBufferedWriter(destination)) {
            while (sourceFile.ready()) {
                char sourceChar = Character.toLowerCase((char)sourceFile.read());
                int oldIndex = alphabet.indexOf(sourceChar);
                int newIndex = oldIndex + (alphabet.size() - (key % alphabet.size()));
                destinationFile.write(alphabet.get(newIndex % alphabet.size()));
            }
            System.out.println("Decoding has been completed");

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
    public String decodeToText(String encodedText, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = encodedText.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int oldIndex = alphabet.indexOf(chars[i]);
            int newIndex = oldIndex + (alphabet.size() - (key % alphabet.size()));
            stringBuilder.append(alphabet.get(newIndex % alphabet.size()));
        }
        return stringBuilder.toString();
    }
}
