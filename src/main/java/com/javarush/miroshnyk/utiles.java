package com.javarush.miroshnyk;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

import static com.javarush.miroshnyk.Runner.directoryPathForWorkFileSave;

public class utiles {
    public static final String symbolsAvailable = "абвгдеёжзийклмнопрстуфхцчшщъыьэя1234567890!@#$%^&*()-_+=?/<>,.[]{} ";
    public static final int SIZE = symbolsAvailable.length();

    private static char symbol_shift(char symbol, int shift){
        if(symbolsAvailable.indexOf(symbol) != -1){
            return symbolsAvailable.charAt((symbolsAvailable.indexOf(symbol) + ((shift % SIZE) + SIZE)) % SIZE);
            //(symbolsAvailable.indexOf(symbol) + ((shift % SIZE) + SIZE)) % SIZE
            //symbolsAvailable.indexOf(symbol) + shift) % SIZE
        } else {
            return symbol;
        }
    }
    public static void encript(int key, ArrayList<String> bufferString){
        for (int i = 0; i<bufferString.size(); i++) {
            String str1 = bufferString.get(i).toLowerCase();
            System.out.println(str1);
            String new_str = "";

            int c = 0;
            int y = 0;

            for (int j = 0; j < str1.length(); j++) {
                    y = symbol_shift(str1.charAt(j), key);
                    new_str += (char) y; // получаем букву по коду
            }
            bufferString.set(i, new_str);
        }
    }

    public static void readFile(Path path, ArrayList<String> bufferString){
        bufferString.clear();
        try(BufferedReader input = new BufferedReader(new FileReader(path.toFile()))){
            {
                String i;
                while((i = input.readLine()) != null){
                    bufferString.add(i);
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void writeFile (Path path, ArrayList<String> bufferString){
        try (BufferedWriter output = new BufferedWriter(new FileWriter(path.toFile()))){
            for (String str:
                    bufferString) {
                output.write(str + "\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createFile (String createFileName){
        try {
            // Возьмите файл
            File f = new File(directoryPathForWorkFileSave + createFileName);

            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

}
