package com.javarush.afanasenko.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForse {
    private final Encoder encoder;

    public BruteForse(Encoder encoder) {
        this.encoder = encoder;
    }

    public void hack() {
        int maxСoincidenceKey = -1;
        int maxСoincidence = -1;
        for (int i = 1; i < Encoder.ALPHABET.length; i++) {
            encoder.setKey(i);
            StringBuilder variant = encoder.encode("decode", "", false);
            int quantityСoincidence = 0;

            Pattern concidienceType = Pattern.compile("[.,] ");
            Matcher matcher = concidienceType.matcher(variant);
            while (matcher.find()) {
                quantityСoincidence++;
            }
            if (quantityСoincidence > maxСoincidence) {
                maxСoincidence = quantityСoincidence;
                maxСoincidenceKey = i;
            }
        }
        if (maxСoincidenceKey != -1) {
            encoder.setKey(maxСoincidenceKey);
            encoder.encode("decode", "text\\bruteForseFile.txt", true);
            System.out.println("Код взломан, ключ для расшифровки: " + maxСoincidenceKey);
        } else System.out.println("\u001B[31m" + "Не удалось взломать код.");
    }
}
