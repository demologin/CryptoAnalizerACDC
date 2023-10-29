package com.javarush.levchuk.mods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Encode {
    public Encode() {
        Scanner input = new Scanner(System.in);
        System.out.println("\"Enter source (full path OR only filename OR Enter for text.txt) :");
        String sourceFile = input.nextLine();
        System.out.println("Enter destination (full path OR only filename OR Enter for encrypted.txt) :");
        String destinationFile = input.nextLine();
        System.out.println("Enter key (int number OR Enter for key=1) :");
        int key = input.nextInt();
        Path source = Path.of(System.getProperty("user.dir") + File.separator + "text" + File.separator);
        if (!sourceFile.equals("")) {
            source = Path.of(sourceFile);
        }

        Path target = Path.of(System.getProperty("user.dir") + File.separator + "text" + File.separator);
        if (!destinationFile.equals("")) {
            target = Path.of(destinationFile);
        }

        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {
        } catch (IOException e) {
            throw new RuntimeException("Incorrect file");
        }
    }
}
