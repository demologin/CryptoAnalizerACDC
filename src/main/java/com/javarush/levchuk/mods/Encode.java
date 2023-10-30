package com.javarush.levchuk.mods;

import com.javarush.levchuk.constant.Alphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.levchuk.constant.Alphabet.*;

public class Encode {
    public Encode() {
        Scanner input = new Scanner(System.in);
        System.out.println("\"Enter source (full path OR only filename OR Enter for text.txt) :");
        String sourceFile = input.nextLine();
        System.out.println("Enter destination (full path OR only filename OR Enter for encrypted.txt) :");
        String destinationFile = input.nextLine();
        System.out.println("Enter key (int number OR Enter for key=1) :");
        int key = input.nextInt();
        Path source = Path.of(System.getProperty("user.dir") + File.separator + "text" + File.separator + "text.txt");
        if (!sourceFile.equals("")) {
            source = Path.of(sourceFile);
        }

        Path target = Path.of(System.getProperty("user.dir") + File.separator + "text" + File.separator + "encodeText.txt");
        if (!destinationFile.equals("")) {
            target = Path.of(destinationFile);
        }

        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {
            int numberChar;
            while ((numberChar = reader.read()) > -1) {
                char charByNumber = (char) numberChar;
                if (alphabetMap.containsKey(charByNumber)) {
                    charByNumber = Character.toLowerCase(charByNumber);
                    int index = getIndexByChar(charByNumber);
                    index = (getAlphabetSize() + (index + key)) % getAlphabetSize();
                    writer.write(getChar(index));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
