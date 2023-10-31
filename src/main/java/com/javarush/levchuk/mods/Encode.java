package com.javarush.levchuk.mods;


import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class Encode {
    public Encode() {
        Scanner input = new Scanner(System.in);

        System.out.println("\"Enter source (Or Enter for text.txt) :");
        String defultSourceName = "text.txt";
        Path source = PathMaker.makePath(defultSourceName);

        System.out.println("Enter destination (Or Enter for encrypted.txt) :");
        String defaultTargetName = "encrypted.txt";
        Path target = PathMaker.makePath(defaultTargetName);

        System.out.println("Enter key (int number OR Enter for key=1) :");
        int key = 1;
        try {
            String keyLine = input.nextLine();
            if (!keyLine.equals("")) {
                key = Integer.parseInt(keyLine);
            }
        } catch (NumberFormatException e){
            System.err.println("Incorrect key format");
        }
            Coding.processingToFile(source, target, key);
    }
}