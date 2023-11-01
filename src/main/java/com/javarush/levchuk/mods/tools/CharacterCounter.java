package com.javarush.levchuk.mods.tools;

import com.javarush.levchuk.constant.Alphabet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

 public abstract class CharacterCounter {
      public static Map<Character, Integer> getMapRepeatedChar(Path source) {
         Map<Character, Integer> map = new HashMap<>();
         try (BufferedReader reader = Files.newBufferedReader(source)) {
             int numberChar;
             while ((numberChar = reader.read()) > -1) {
                 char charByNumber = Character.toLowerCase((char) numberChar);
                 if (Alphabet.alphabetMap.containsKey(charByNumber)){
                     if (map.containsKey(charByNumber)) {
                         map.put(charByNumber, map.get(charByNumber) + 1);
                     } else {
                         map.put(charByNumber, 1);
                     }
                 }
             }
         } catch (NoSuchFileException e) {
             System.err.println("Incorrect file path has been entered");
         } catch (IOException e) {
             throw new RuntimeException(e.getMessage());
         }
         return map;
     }
     public static Map<Character, Integer> getMapRepeatedChar(Path source, int key) {
         Map<Character, Integer> map = new HashMap<>();
         try (BufferedReader reader = Files.newBufferedReader(source)) {
             int numberChar;
             while ((numberChar = reader.read()) > -1) {
                 char charByNumber = Character.toLowerCase((char) numberChar);
                 if (Alphabet.alphabetMap.containsKey(charByNumber)) {
                     char codingChar = Coding.charEncryptor(charByNumber, key);
                     if (map.containsKey(codingChar)) {
                         map.put(codingChar, map.get(codingChar) + 1);
                     } else {
                         map.put(codingChar, 1);
                     }
                 }
             }
         } catch (NoSuchFileException e) {
             System.err.println("Incorrect file path has been entered");
         } catch (IOException e) {
             throw new RuntimeException(e.getMessage());
         }
         return map;
     }

      public static int numberRepetitionsChar(Path path, char findChar) {
         int numberCount=0;
         for (Map.Entry<Character, Integer> entry : getMapRepeatedChar(path).entrySet()) {
             if (entry.getKey() == findChar) {
                 numberCount=entry.getValue();
             }
         }
         return numberCount;
     }      public static int numberRepetitionsChar(Path path, char findChar,int key) {
         int numberCount=0;
         for (Map.Entry<Character, Integer> entry : getMapRepeatedChar(path, key).entrySet()) {
             if (entry.getKey() == findChar) {
                 numberCount=entry.getValue();
             }
         }
         return numberCount;
     }
 }
