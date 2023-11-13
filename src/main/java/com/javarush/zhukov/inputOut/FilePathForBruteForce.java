package com.javarush.zhukov.inputOut;

import java.nio.file.Path;
import java.util.Scanner;

public class FilePathForBruteForce extends FilePathForDecode {
    public static Path getPathWriteFile() {
        Path pathFile;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу для записи(по умолчанию будет bruteForce.txt)");
        String scanPath = scanner.nextLine();
        if (!scanPath.isEmpty()) {
            pathFile = Path.of(scanPath);
        } else {
            pathFile = Path.of("text", "bruteForce.txt");
        }
        return pathFile;
    }
}

