package com.javarush.zhukov.inputOut;

import java.nio.file.Path;
import java.util.Scanner;

public class FilePathForEncode {
    public static Path getPathReadFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу для чтения(по умолчанию будет dict.txt.)");
        String scanPath = scanner.nextLine();
        if (!scanPath.isEmpty()) {
            return Path.of(scanPath);
        } else {
            return Path.of("text", "dict.txt");
        }
    }

    public static Path getPathWriteFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу для записи(по умолчанию будет encode.txt)");
        String scanPath = scanner.nextLine();
        if (!scanPath.isEmpty()) {
            return Path.of(scanPath);
        } else {
            return Path.of("text", "encode.txt");
        }
    }
}
