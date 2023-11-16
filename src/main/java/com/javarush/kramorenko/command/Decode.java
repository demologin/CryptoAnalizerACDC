package com.javarush.kramorenko.command;


import com.javarush.kramorenko.constants.Const;
import com.javarush.kramorenko.exception.AppException;
import com.javarush.kramorenko.util.PathBuilder;
import com.javarush.kramorenko.viewConsole.Messages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Decode {
    CeasarCipher ceasarCipher = new CeasarCipher();
    Scanner scanner = new Scanner(System.in);
    public void decode() {
        System.out.println(Messages.PATH_FOR_DECODE);
        String inputFileName = scanner.nextLine();
        System.out.println(Messages.PATH_TARGET);
        String outputFileName = scanner.nextLine();
        System.out.println(Messages.ENTER_KEY);
        int key = scanner.nextInt();

        Path source = PathBuilder.getPath(inputFileName);
        Path target = PathBuilder.getPathDec(outputFileName);

        try (BufferedReader bufferedReader = Files.newBufferedReader(source);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(target)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String decrypted = ceasarCipher.decryptText(string, key);
                bufferedWriter.write(decrypted+System.lineSeparator());
            }
        } catch (IOException e) {
            throw new AppException(Messages.INCORRECT_FILE + e.getMessage(), e);
        }
        System.out.println(Const.DECRYPTION_COMPLETE);
    }
}
