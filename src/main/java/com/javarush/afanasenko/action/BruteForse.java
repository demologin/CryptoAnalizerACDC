package com.javarush.afanasenko.action;

import com.javarush.afanasenko.objects.Encoder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
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
            List<String> variant = encoder.encode("decode", "", false);
            int quantityСoincidence = 0;
          /*  for (int j = 0; j < variant.size() - 1; j++) {
                if ((variant.get(j).equals('.') && variant.get(j + 1).equals(' ')) ||
                        (variant.get(j).equals(',') && variant.get(j + 1).equals(' ')))
                    quantityСoincidence++;
            }*/
                Pattern coincidence = Pattern.compile("[.,]\s");
                Matcher matcher = coincidence.matcher(String.join("", variant));
                while(matcher.find()){
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
