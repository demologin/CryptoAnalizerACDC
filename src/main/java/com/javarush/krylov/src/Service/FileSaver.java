
package com.javarush.krylov.src.Service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileSaver {

    public void saveText(String message, String path) {
        Path outputPath = Paths.get(path).toAbsolutePath();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            writer.write(message);
            System.out.println("Text saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
