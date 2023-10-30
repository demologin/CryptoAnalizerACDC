package com.javarush.zhukov.inputOut;

import java.nio.file.Path;
import java.util.Scanner;

public class FilePathForDecode {
    public static Path getPathReadFile() {
        Path pathFile;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу для чтения(по умолчанию будет encode.txt.)");
        String scanPath = scanner.nextLine();
        if (!scanPath.isEmpty()) {
            pathFile = Path.of(scanPath);
        } else {
            pathFile = Path.of("text", "encode.txt");
        }
        return pathFile;
    }

    public static Path getPathWriteFile() {
        Path pathFile;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу для записи(по умолчанию будет decode.txt");
        String scanPath = scanner.nextLine();
        if (!scanPath.isEmpty()) {
            pathFile = Path.of(scanPath);
        } else {
            pathFile = Path.of("text", "decode.txt");
        }
        return pathFile;
    }
}
