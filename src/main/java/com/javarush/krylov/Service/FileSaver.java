
package com.javarush.krylov.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileSaver {

    public void saveText(String message, String path) {
        Path outputPath = Path.of(path);
        if (isNotAbsolutePath(path)) {
            outputPath = (outputPath.toAbsolutePath());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            writer.write(message);
            System.out.println("Text saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isNotAbsolutePath(String path) {
        return !Paths.get(path).isAbsolute();
    }
}
