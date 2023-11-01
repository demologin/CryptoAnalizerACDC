package com.javarush.levchuk.mods;



import com.javarush.levchuk.mods.tools.CharacterCounter;
import com.javarush.levchuk.mods.tools.PathMaker;
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
        textAnalyzer(source);
    }

    public void textAnalyzer(Path sours) {
        Map<Character, Integer> exampleMap = CharacterCounter.getMapRepeatedChar(Path.of(DICTIONARY_TEXT_SOURCE));
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(exampleMap.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(sortedMap);

        Map<Character, Integer> encryptMap = CharacterCounter.getMapRepeatedChar(sours);
        List<Map.Entry<Character, Integer>> list1 = new ArrayList<>(encryptMap.entrySet());
        list1.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        Map<Character, Integer> newSortedmap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list1) {
            newSortedmap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(newSortedmap);

    }
}
