package com.javarush.levchuk.mods;

import com.javarush.levchuk.mods.tools.Coding;
import com.javarush.levchuk.mods.tools.PathMaker;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.*;

public class Decode {
    public Decode() {

        System.out.println("Enter the path to the file or its name if it is in the default folder (Or Enter for encrypted.txt) :");
        Path source = PathMaker.makePath(DEFAULT_ENCRYPT_FILE_NAME);

        System.out.println("Enter the path or name for the output file (Or Enter for decrypted.txt ) :");
        Path target = PathMaker.makePath(DEFAULT_DECRYPT_FILE_NAME);

        System.out.println("Enter key (int number OR Enter for key=1) :");

        int key = enterKey();
        Coding.processingToFile(source, target, -1 * key);
    }

    public int enterKey(){
        int key = 1;
        try (Scanner scanner=new Scanner(System.in)) {
            String keyLine = scanner.nextLine();
            if (!keyLine.equals("")) {
                key = Integer.parseInt(keyLine);
            }
        } catch (Exception e){
            throw new RuntimeException();
        }
        return key;
    }
}
