package com.javarush.levchuk.mods;

import com.javarush.levchuk.mods.tools.Coding;
import com.javarush.levchuk.mods.tools.PathMaker;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.levchuk.constant.UtilConstants.*;

public class Decode {
    public void runDecode() {

        System.out.println("Enter the path to the file or its name if it is in the default folder (Or Enter for encrypted.txt) :");
        Path source = PathMaker.makePath(DEFAULT_ENCRYPT_FILE_NAME);

        System.out.println("Enter the path or name for the output file (Or Enter for decrypted.txt ) :");
        Path target = PathMaker.makePath(DEFAULT_DECRYPT_FILE_NAME);

        System.out.println("Enter key (int number OR Enter for key=1) :");
        Scanner scanner=new Scanner(System.in);
        String keyLine = scanner.nextLine();
        int key = 1;
        if (!keyLine.equals("")) {
            key = Integer.parseInt(keyLine);
        }
        Coding.processingToFile(source, target, -1 * key);
    }
}
