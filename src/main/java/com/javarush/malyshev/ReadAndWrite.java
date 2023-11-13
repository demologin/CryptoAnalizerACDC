package com.javarush.malyshev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ReadAndWrite {
    public static ReadAndWrite readAndWrite = new ReadAndWrite();

    Path src;
    Path dest;
    String srcText;


    public ReadAndWrite() {
    }

    public void enterTheFiles() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the absolute path to the source:");
        src = Path.of(scanner.nextLine());


        System.out.println("Enter the absolute path to the destination:");
        dest = Path.of(scanner.nextLine());

    }

    public String readTheFile() throws IOException {
        return srcText = Files.readString(this.src);
    }

    public void writeTheFile(String src) throws IOException {
        Files.writeString(dest, src);
        System.out.println("Data is recorded to " + dest);
    }
}
