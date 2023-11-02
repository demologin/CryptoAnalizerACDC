/*
package com.javarush.levchuk.mods;

import com.javarush.levchuk.mods.tools.CharacterCounter;
import com.javarush.levchuk.mods.tools.PathMaker;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import static com.javarush.levchuk.constant.UtilConstants.*;


public class Analyze {


    public Analyze() {
        System.out.println("Enter the path to the file or its name if it is " +
                "in the default folder (Or Enter for encrypted.txt) :");
        String defaultSourceName = "encrypted.txt";
        Path source = PathMaker.makePath(defaultSourceName);
        System.out.println("Enter the path or name for the output file (Or Enter for analyzeDecrypted.txt ) :");
        String defaultTargetName = "analyzeDecrypted.txt";
        Path target = PathMaker.makePath(defaultTargetName);
        System.out.println("Enter the path or name of the dictionary(Or Enter to use the default dictionary) :");
        String defaultDictName = "dict.txt";
        Path dict = PathMaker.makePath(defaultDictName);
        textAnalyzer(source);
        decipherByAnalysis(source,dict);
    }

    public Map<Character, Integer> textAnalyzer(Path sours) {
        Map<Character, Integer> exampleMap = CharacterCounter.getMapRepeatedChar(sours);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(exampleMap.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
    public Map<Character,Character> matchChars(Path source, Path dict){
        Map<Character,Character> charsMap= new HashMap<>();
        Map <Character, Integer> sortedAnalyze=textAnalyzer(source);
        System.out.println(sortedAnalyze);
        Map <Character, Integer> sortedDict = textAnalyzer(dict);
        System.out.println(sortedDict);
        for (Map.Entry <Character, Integer> entry:sortedAnalyze.entrySet()) {
            char analyzeChar=  entry.getKey();
            if (entry.getKey()!=0){
            for (Map.Entry <Character, Integer> entryTwo:sortedDict.entrySet()) {
                char dictChar = entryTwo.getKey();
                if (entry.getKey()!=0 && entryTwo.getKey()!=0 ) {
                    charsMap.put(analyzeChar, dictChar);
                    break;
                }
            }
        }

        }
        return charsMap;
    }
    public void decipherByAnalysis( Path source, Path dict ) {
        Map<Character,Character> charsMap=matchChars(source,dict);
        try (BufferedReader reader=Files.newBufferedReader(source);
             BufferedWriter writer=Files.newBufferedWriter(dict)) {
            int numberChar;
            while ((numberChar=reader.read())>-1){
                char charByNumber = Character.toLowerCase((char) numberChar);
                writer.write(charsMap.get(charByNumber));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
*/
