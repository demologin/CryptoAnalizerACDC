package com.javarush.kramorenko.command;

import com.javarush.kramorenko.util.PathBuilder;
import com.javarush.kramorenko.constants.Const;
import com.javarush.kramorenko.exception.AppException;
import com.javarush.kramorenko.viewConsole.Messages;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Encode {
    private final CeasarCipher ceasarCipher = new CeasarCipher();
    private final Scanner scanner = new Scanner(System.in);
    public void encode() {
        System.out.println(Messages.PATH_FOR_ENCODE);
        String inputFileName = scanner.nextLine();
        System.out.println(Messages.PATH_TARGET);
        String outputFileName = scanner.nextLine();
        System.out.println(Messages.ENTER_KEY);
        int key = scanner.nextInt();

        Path source = PathBuilder.get(inputFileName);
        Path target = PathBuilder.getPath(outputFileName);

        try (BufferedReader bufferedReader = Files.newBufferedReader(source);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(target)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String encrypted = ceasarCipher.encryptText(string, key);
                bufferedWriter.write(encrypted+System.lineSeparator());
            }
        } catch (IOException e) {
            throw new AppException(Messages.INCORRECT_FILE+ e.getMessage(),e);
        }
        System.out.println(Const.ENCRYPTION_COMPLETE);
    }
}
