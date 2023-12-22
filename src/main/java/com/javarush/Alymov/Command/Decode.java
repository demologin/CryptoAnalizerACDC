package com.javarush.Alymov.Command;

import com.javarush.Alymov.constant.Alphabet;
import com.javarush.Alymov.constant.Const;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decode{
    public static void decoder (String sourcePath, String destinationPath, int step) {

        try (
                BufferedReader bufferedReader = Files.newBufferedReader( Path.of(sourcePath));
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(destinationPath))
        )
        {
            int valueOfChar;
            int alphabetLength = Alphabet.index.size();
            while ((valueOfChar = bufferedReader.read()) > -1) {
                char charecter = (char) valueOfChar;
                if (Alphabet.index.containsKey(charecter)) {
                    int index = Alphabet.index.get(charecter);
                    int newIndex = (index + (-1* step) + Math.abs((-1* step)) * alphabetLength) % alphabetLength;
                    bufferedWriter.write(Alphabet.CHARS[newIndex]);
                } else if (charecter == '\n') {
                    bufferedWriter.write(charecter);
                }

            }

        } catch (Exception e) {
            System.out.println(Const.ERROR_MESSAGE + e);
        }

    }



}
