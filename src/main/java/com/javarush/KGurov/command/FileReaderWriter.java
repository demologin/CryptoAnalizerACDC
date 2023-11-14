package com.javarush.KGurov.command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileReaderWriter {
    public static FileReaderWriter fileReaderWriter = new FileReaderWriter();
    Path source;
    Path destination;
    String text;
    public FileReaderWriter() {
    }
    public void enterFiles() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source full path:");
        source = Path.of(scanner.nextLine());
        System.out.println("Enter destination full path:");
        destination = Path.of(scanner.nextLine());
    }
    public String readFiles() throws IOException {
        return text = Files.readString(this.source);
    }
    public void writeFiles(String src) throws IOException {
        Files.writeString(destination, src);
        System.out.println("Data is recorded to " + destination);
    }
}