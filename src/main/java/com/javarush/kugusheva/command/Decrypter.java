package com.javarush.kugusheva.command;

import com.javarush.kugusheva.helpers.PathMaker;
import com.javarush.kugusheva.resources.Alphabet;
import com.javarush.kugusheva.resources.Decrypter_messages;
import com.javarush.kugusheva.resources.Encrypter_messages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Decrypter {

    public static void decrypt() {
        System.out.println(Decrypter_messages.INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        Path inputPath = PathMaker.getPath(scanner.nextLine(), 2);
        System.out.println(Decrypter_messages.OUTPUT_MESSAGE);
        Path outputPath = PathMaker.getPath(scanner.nextLine(), 3);
        System.out.println(Decrypter_messages.SHIFT_MESSAGE);
        int shift = scanner.nextInt();
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(inputPath);
                BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath);
        ) {
            int valueOfChar;
            int alphabetLength = Alphabet.ALPHABET_MAP.size();
            while ((valueOfChar = bufferedReader.read()) > -1) {
                char charecter = (char) valueOfChar;
                charecter = Character.toLowerCase(charecter);
                if (Alphabet.ALPHABET_MAP.containsKey(charecter)) {
                    int index = Alphabet.ALPHABET_MAP.get(charecter);
                    int newIndex = (index + (-1*shift) + Math.abs((-1*shift)) * alphabetLength) % alphabetLength;
                    bufferedWriter.write(Alphabet.CHAR_ARRAY[newIndex]);
                } else if (charecter == '\n') {
                    bufferedWriter.write(charecter);
                }

            }

        } catch (Exception e) {
            System.out.println(Decrypter_messages.ERROR_MESSAGE + e);
        }

    }


}


