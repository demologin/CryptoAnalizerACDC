package com.javarush.krylov.src.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TextFromFileLoader {

    public String getText(String path) {
        Path inputPath = Paths.get(path).toAbsolutePath();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath.toFile()))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
