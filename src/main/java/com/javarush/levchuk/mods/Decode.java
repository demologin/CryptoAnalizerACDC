package com.javarush.levchuk.mods;

import java.nio.file.Path;
import java.util.Scanner;

public class Decode {
    public Decode() {
        Scanner input = new Scanner(System.in);

        System.out.println("\"Enter full source (Or Enter for encrypted.txt) :");
        String defultSourceName = "encrypted.txt";
        Path source = PathMaker.makePath(defultSourceName);

        System.out.println("Enter destination (Or Enter for decrypted.txt ) :");
        String defaultTargetName = "decrypted.txt";
        Path target = PathMaker.makePath(defaultTargetName);

        System.out.println("Enter key (int number OR Enter for key=1) :");
        int key = 1;
        String keyLine = input.nextLine();
        if (!keyLine.equals("")) {
            key = Integer.parseInt(keyLine);
        }

        Coding.processingToFile(source, target, -1 * key);
        System.out.println("COMPLIED");
    }
}
