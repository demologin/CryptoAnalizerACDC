package com.javarush.maikov.bruteforce;

import com.javarush.maikov.constatns.Constants;
import com.javarush.maikov.decode.Decode;
import com.javarush.maikov.util.PathBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.maikov.ConsoleRunner.input;

public class BruteForce {
        public BruteForce(String linkIn, String linkOut) {
            Map<Integer, String> mapBrute = new HashMap<>();
            for (int i = 1; i <= Constants.ALPHABET.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                int key = i;
                Decode bruteDecode = new Decode(linkIn, linkOut, key);
                try (FileReader fileReader = new FileReader(String.valueOf(PathBuilder.getPath(linkOut)))){
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line;
                    while ((line =reader.readLine()) != null){
                        stringBuilder.append(line);
                    }
                mapBrute.put(key, String.valueOf(stringBuilder));

                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден, укажите путь к действующему файлу");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            for(Map.Entry<Integer, String> entry : mapBrute.entrySet()){
                int key = entry.getKey();
                System.out.print(key + " : ");
                System.out.println(mapBrute.get(key));
                System.out.println("======================");
            }
            System.out.println("Выберите значение ключа, которое расшифровывает данный файл");
            int keySolution = input.nextInt();
            String value = mapBrute.get(keySolution);
            try (FileWriter fileWriter = new FileWriter(String.valueOf(PathBuilder.getPath(linkOut)))){
                fileWriter.write(value);

            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден, укажите путь к действующему файлу");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}