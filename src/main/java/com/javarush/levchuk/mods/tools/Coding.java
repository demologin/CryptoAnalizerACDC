package com.javarush.levchuk.mods.tools;

import com.javarush.levchuk.constant.Alphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.levchuk.constant.Alphabet.*;
import static com.javarush.levchuk.constant.UtilConstants.*;

public abstract class Coding {
    public static void processingToFile(Path source, Path target, int key){
        int numberChar = 0;
        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {
            while ((numberChar = reader.read()) > -1) {
                char charByNumber = Character.toLowerCase((char) numberChar);
                writer.write(charEncryptor(charByNumber,key));
            }
        }catch (NoSuchFileException e) {
            System.err.printf(ERROR_MESSAGES[2]);
        }catch (IOException e) {
            throw new RuntimeException();
        }
        if (numberChar==-1){
            System.out.printf(ANSI_GREEN+CONTEXT_MESSAGES[3]+target+ANSI_RESET);
        }
    }
    public static char charEncryptor(char character, int key){
        if (alphabetMap.containsKey(character)) {
            int index = getIndexByChar(character);
            index = (getAlphabetSize() * Math.abs(key) + (index + key)) % getAlphabetSize();
            return Alphabet.getChar(index);
        }
        return character;
    }
    public static int enterKey(){
        try {
            Scanner input = new Scanner(System.in);
            String keyLine = input.nextLine();
            if (!keyLine.equals("")) {
                int key = Integer.parseInt(keyLine);
                return key;
            }
        } catch (NumberFormatException e){
            System.err.println(ERROR_MESSAGES[0]);
        }
        return DEFAULT_KEY;
    }
}