package com.javarush.krylov.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextFromFileLoader {

    public String getText(String path) {
        Path inputPath = Path.of(path);
        if (isNotAbsolutePath(path)) {
            inputPath = (inputPath.toAbsolutePath());
        }
        try {
            List<String> lines = Files.readAllLines(inputPath);
            return String.join("\n", lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
    private boolean isNotAbsolutePath(String path) {
        return !Paths.get(path).isAbsolute();
    }
}
