package com.javarush.levchuk.mods;

import com.javarush.levchuk.mods.tools.Coding;
import com.javarush.levchuk.mods.tools.PathMaker;

import java.nio.file.Path;
import java.util.Scanner;

public class Decode {
    public Decode() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the path to the file or its name if it is in the default folder (Or Enter for encrypted.txt) :");
        String defultSourceName = "encrypted.txt";
        Path source = PathMaker.makePath(defultSourceName);

        System.out.println("Enter the path or name for the output file (Or Enter for decrypted.txt ) :");
        String defaultTargetName = "decrypted.txt";
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
        Coding.processingToFile(source, target, -1 * key);
    }
}
