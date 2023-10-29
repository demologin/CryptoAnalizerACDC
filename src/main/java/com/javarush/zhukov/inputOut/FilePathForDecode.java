package com.javarush.zhukov.inputOut;

import java.nio.file.Path;
import java.util.Scanner;

public class FilePathForDecode {
    public static Path getPathReadFile(){
        Path pathFile;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла(по умлочанию будет encode.txt.)");
        String scanPath = scanner.nextLine();
        if (!scanPath.isEmpty()){
            pathFile= Path.of(scanPath);
        }else {
            pathFile= Path.of("text","encode.txt");
        }
        return  pathFile;
    }public static Path getPathWriteFile(){
        Path pathFile;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла(по умлочанию будет decode.txt)");
        String scanPath = scanner.nextLine();
        if (!scanPath.isEmpty()){
            pathFile= Path.of(scanPath);
        }else {
            pathFile= Path.of("text","result.txt");
        }
        return  pathFile;
    }
}
