package com.javarush.maikov;

import java.io.*;
import java.util.Arrays;


public class Encode {
    public Encode(String link, int key) {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(link)) {
            while (reader.ready()) {
                char target = (char) reader.read();
                boolean isCharAlphabet = Arrays.toString(Constants.ALPHABET).contains(Character.toString(target));
                boolean isCharCapital = Arrays.toString(Constants.CAPITALLETTER).contains(Character.toString(target));
                if(isCharAlphabet){
//                    result.append(Constants.ALPHABET[])
                }
            }
            System.out.println(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

