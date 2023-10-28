package com.javarush.stukalov.services;

import com.javarush.stukalov.constant.Alphabet;
import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Encoder {
    public static void encode(Path source, Path destination, int key)  {
        List<Character> chars = Alphabet.getListOfCHARS();
        try(BufferedReader sourceFile = new BufferedReader(new FileReader(source.toFile()));
        BufferedWriter destinationFile = new BufferedWriter(new FileWriter(destination.toFile()))) {
            while (sourceFile.ready()) {
                char sourceChar = Character.toLowerCase((char)sourceFile.read());
                int oldIndex = chars.indexOf(sourceChar);
                int newIndex = (oldIndex + key) % chars.size();
                destinationFile.write(chars.get(newIndex));
            }

        } catch (Throwable e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Cannot read the source file");
            } else if (e instanceof IndexOutOfBoundsException) {
                System.out.println("There is no such a character in the Alphabet");
            } else if (e instanceof IOException){
                System.out.println("Cannot write the source file");
            } else if (e instanceof NullPointerException) {
                System.out.println("The was a null somewhere");
                e.printStackTrace();
            }
        }

    }
}
