package com.javarush.afanasenko;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;



public class TextHandler {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    private HashMap<Integer, Character> map;
    public TextHandler(Path path){
       map = textFromFile(path);
     }
    public TextHandler(HashMap<Integer,Character> map){
        this.map = map;
    }

    public static HashMap<Integer, Character> textFromFile(Path path) {
        HashMap<Integer, Character> text= new HashMap<>();
        if (Files.isRegularFile(path)) {
            try {
                byte[] byteArray = Files.readAllBytes(path);
                for (int i = 0; i < byteArray.length; i++) {
                    text.put(i, (char) byteArray[i]);
                }
            } catch (IOException ex) {
                throw new CryptoException("Проблема при чтении файла");
            }
        }
        return text;
    }
    public static void TextToFile(HashMap<Integer, Character> text) {

    }
}



